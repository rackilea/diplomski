package demo;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Pattern;

import com.sun.japex.TestCase;

public abstract class AbstractDirectoryFilesReadDriver extends com.sun.japex.JapexDriverBase
{
    private final int bufferSize;

    protected AbstractDirectoryFilesReadDriver(int bufferSize)
    {
        super();
        this.bufferSize=bufferSize;
    }

    @Override
    public void run(TestCase testCase)
    {
        int numberOfThreads=testCase.getIntParam("number_threads");
        final String mask=testCase.getParam("filename_mask");
        File dir=new File(testCase.getParam("dir"));
        long totalSize=testCase.getLongParam("total_size");
        File[] list=dir.listFiles(new FilenameFilter()
        {
            @Override
            public boolean accept(File dir, String name)
            {
                return Pattern.matches(mask, name);
            }
        });

        // Split the list of files between a number of threads.
        Collection<Collection<File>> collections=splitDirList(list, numberOfThreads);

        // Start the threads and let every one read its subset of files.
        Collection<Thread> threads=new ArrayList<Thread>(numberOfThreads);
        Collection<MyRunnable> runnables=new ArrayList<MyRunnable>(numberOfThreads);
        for (Collection<File> collection : collections)
        {
            MyRunnable runnable=new MyRunnable(collection);
            runnables.add(runnable);
            Thread thread=new Thread(runnable);
            threads.add(thread);
            thread.start();
        }
        try
        {
            for (Thread thread : threads)
            {
                thread.join();
            }

            // Check the read size: Ensure that all the files have been fully read:
            long size=0;
            for (MyRunnable runnable : runnables)
            {
                size+=runnable.getSize();
            }

            System.out.println("numberOfThreads=" + numberOfThreads + ", size=" + size);
            if (size != totalSize)
            {
                throw new RuntimeException("Size check failed: expected size=" + totalSize + ", read size=" + size);
            }
        }
        catch (InterruptedException e)
        {
            throw new Error(e);
        }
    }

    private Collection<Collection<File>> splitDirList(File[] list, int numberOfParts)
    {
        int n=0;
        Collection<Collection<File>> collection=new ArrayList<Collection<File>>(numberOfParts);
        int load=(int)Math.ceil(list.length / (double)numberOfParts);
        for (int i=0; i < numberOfParts; i++)
        {
            Collection<File> part=new ArrayList<File>(load);
            for (int j=0; j < load && n < list.length; j++)
            {
                part.add(list[n++]);
            }
            collection.add(part);
        }
        return collection;
    }

    private long readFiles(Collection<File> files)
        throws FileNotFoundException,
        IOException
    {
        long size=0;
        for (File file : files)
        {
            size+=readInputStream(createInputStream(file));
        }
        return size;
    }

    private InputStream createInputStream(File file)
        throws FileNotFoundException
    {
        InputStream input=new FileInputStream(file);
        if (this.bufferSize > 0)
        {
            input=new BufferedInputStream(input, this.bufferSize);
        }
        return input;
    }

    /**
     * Reads fully a inputStream.
     * 
     * @param input InputStream.
     * @return Content as String.
     * @exception java.io.IOException If an error occured while reading.
     */
    private static long readInputStream(java.io.InputStream input)
        throws java.io.IOException
    {
        long size=0;
        byte[] buffer=new byte[4096];
        int n;
        do
        {
            n=input.read(buffer);
            if (n > 0)
            {
                size+=n;
            }
        }
        while (n >= 0);
        return size;
    }

    private class MyRunnable implements Runnable
    {
        private final Collection<File> files;

        public MyRunnable(Collection<File> files)
        {
            super();
            this.files=files;
        }

        private long size;

        public long getSize()
        {
            return this.size;
        }

        @Override
        public void run()
        {
            try
            {
                this.size=readFiles(this.files);
            }
            catch (IOException e)
            {
                throw new Error(e);
            }
        }
    }
}

public class UnbufferedDirectoryFilesReadDriver extends AbstractDirectoryFilesReadDriver
{
    public UnbufferedDirectoryFilesReadDriver()
    {
        super(0);
    }
}

public class Buffered4096DirectoryFilesReadDriver extends AbstractDirectoryFilesReadDriver
{
    public Buffered4096DirectoryFilesReadDriver()
    {
        super(4096);
    }
}

public class Buffered8192DirectoryFilesReadDriver extends AbstractDirectoryFilesReadDriver
{
    public Buffered8192DirectoryFilesReadDriver()
    {
        super(8192);
    }
}