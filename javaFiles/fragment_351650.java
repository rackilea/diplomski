package com.example.timing;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    EditText Seconds;   
    String s;
    Button button;
    byte[] buffer = new byte[65535];
    InetAddress ia = null;
    int port = 4321;     
    DatagramPacket dp = new DatagramPacket(buffer, buffer.length,ia,port);
    MulticastSocket ms = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);     
        Seconds = (EditText) findViewById(R.id.et_time);    
        WifiManager wm = (WifiManager)getSystemService(Context.WIFI_SERVICE); 

        Handler handler = new Handler();
        SocketThread thread = new SocketThread(handler, wm);
        thread.start();
    }



    class SocketThread extends Thread  {
        private final Handler mHandler;

        SocketThread(Handler handler, WifiManager wifiManager) {
            mHandler = handler;
        }
        @Override 
        public void run() {
            // socket code goes here            
            try {     
                wm.setWifiEnabled(true);        
                WifiManager.MulticastLock multicastLock = wm.createMulticastLock("multicastLock");
                multicastLock.setReferenceCounted(true);        
                multicastLock.acquire();            

                ia = InetAddress.getByName("226.1.1.1");         
                ms.setReuseAddress(true);
                ms.joinGroup(ia);

                while(true) {
                ms.receive(dp);     
                    s = new String(dp.getData(),0,dp.getLength());
                    update(s);
                }
            } catch (UnknownHostException e) {
                update(e.getMessage());
            } catch (IOException e) {
                update(e.getMessage());
            }       
        }
    }


    public void update(String s)
    {
        Seconds.setText(s);
    }   

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


}