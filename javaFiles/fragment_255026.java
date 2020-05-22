package ru.donz.util.javatools;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: Donz
 * Date: 25.05.2010
 * Time: 21:57:52
 * Start process, read all its streams and write them to pointed streams.
 */
public class ConsoleProcessExecutor
{
    /**
     * Start process, redirect its streams to pointed streams and return only after finishing of this process
     *
     * @param args        process arguments including executable file
     * @param runtime just Runtime object for process
     * @param workDir working dir
     * @param out         stream for redirecting System.out of process
     * @param err         stream for redirecting System.err of process
     * @throws IOException
     * @throws InterruptedException
     */
    public static void execute( String[] args, Runtime runtime, File workDir, OutputStream out, OutputStream err )
            throws IOException, InterruptedException
    {
        Process process = runtime.exec( args, null, workDir );

        new Thread( new StreamReader( process.getInputStream(), out ) ).start();
        new Thread( new StreamReader( process.getErrorStream(), err ) ).start();

        int rc = process.waitFor();
        if( rc != 0 )
        {
            StringBuilder argSB = new StringBuilder( );
            for( String arg : args )
            {
                argSB.append( arg ).append( ' ' );
            }
            throw new RuntimeException( "Process execution failed. Return code: " + rc + "\ncommand: " + argSB );
        }
    }

}

class StreamReader implements Runnable
{
    private final InputStream in;
    private final OutputStream out;


    public StreamReader( InputStream in, OutputStream out )
    {
        this.in = in;
        this.out = out;
    }

    @Override
    public void run()
    {
        int c;
        try
        {
            while( ( c = in.read() ) != -1 )
            {
                out.write( c );
            }
            out.flush();
        }
        catch( IOException e )
        {
            e.printStackTrace();
        }
    }
}