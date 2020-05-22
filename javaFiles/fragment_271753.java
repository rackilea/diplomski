package com.example.app;

import android.app.Activity;
import android.media.MediaRecorder;
import android.net.LocalServerSocket;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.Bundle;

import java.io.IOException;

public class MainActivity extends Activity
{
    private final String SOCKET_ADDRESS = "socket1";
    private MediaRecorder mRecorder = new MediaRecorder();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        class IOThread extends Thread
        {
            @Override
            public void run()
            {
                System.out.println("--------IO Thread------ ");
                LocalSocket receiver;
                LocalServerSocket server;

                try
                {
                    server = new LocalServerSocket(SOCKET_ADDRESS);

                    localServerCreated();
                    receiver = server.accept();

                    System.out.println("---------server.accept();------------- ");

                    int ret = 0;
                    while ((ret = receiver.getInputStream().read()) != -1)
                    {
                        System.out.println( "ret =" + ret);
                    }

                    System.out.println("ret =" + ret);

                }
                catch (IOException e)
                {
                }

            }
        }
        IOThread io1 = new IOThread();
        io1.start();


    }

    private void localServerCreated()
    {
        LocalSocket sender;
        try
        {
            sender = new LocalSocket();
            sender.connect(new LocalSocketAddress(SOCKET_ADDRESS));

            mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mRecorder.setOutputFormat(MediaRecorder.OutputFormat.AAC_ADTS);
            mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
            mRecorder.setOutputFile(sender.getFileDescriptor());

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("------mRecorder configured--------");
        try
        {
            mRecorder.prepare();
            mRecorder.start();
            System.out.println("------mRecorder.start()--------");
        }
        catch (IllegalStateException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }


}