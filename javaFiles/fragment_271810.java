package com.example.servicesample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.lang.Thread;
import android.support.v4.content.LocalBroadcastManager;

public class MyService extends Service implements Runnable {
    public static final String ROOM_STATUS_BROADCAST = "com.example.room_status_broadcast";
    public static final String ROOM_STATUS_BROADCAST_EXTRA_ROOM_NUMBER = "roomnumber";
    public static final String ROOM_STATUS_BROADCAST_EXTRA_STATUS = "status";

    static final int NUM_ROOMS = 7;
    static final int TIME_FOR_A_REST = 5000; //ms

    Thread mThread = null;
    Boolean mRunning = false;

    @Override
    public void onCreate() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        start();

        return  START_STICKY;
    }

    @Override
    public void onDestroy() {
        stop();
    }

    private synchronized void start()
    {
        if (mThread != null)
            return;

        mRunning = true;
        mThread = new Thread(this);
        mThread.start();
    }

    private synchronized void stop()
    {
        if (mThread == null)
            return;

        mRunning = true;

        try
        {
            mThread.join();
        } catch (InterruptedException e) {}
        mThread = null;
    }


    public void run()
    {
        while (mRunning)
        {
            for (int i = 0; i < NUM_ROOMS; i++)
                updateRoomStatus(i);

            try
            {
                Thread.sleep(TIME_FOR_A_REST);
            } catch (InterruptedException e) {}             
        }
    }

    Boolean getRoomStatus(int roomNumber)
    {
        // Do real communication here (instea of just assigning true)
        // It makes sense to move all communication to a separate class from here
        Boolean newRoomStatus = true;

        return newRoomStatus;
    }

    void updateRoomStatus(int roomNumber)
    {
        Boolean newRoomStatus = getRoomStatus(roomNumber);
        broadcastRoomStatus(roomNumber, newRoomStatus);
    }

    void broadcastRoomStatus(int roomNumber, Boolean newRoomStatus)
    {
        Intent intent = new Intent(ROOM_STATUS_BROADCAST);
        intent.putExtra(ROOM_STATUS_BROADCAST_EXTRA_ROOM_NUMBER, roomNumber);
        intent.putExtra(ROOM_STATUS_BROADCAST_EXTRA_STATUS, newRoomStatus);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

}