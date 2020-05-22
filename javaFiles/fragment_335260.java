package com.example.jeudumemo;

import android.graphics.Canvas;

public class GameLoopThread extends Thread
{
    private final static int FRAMES_PER_SECOND = 30;

    private final static int SKIP_TICKS = 1000 / FRAMES_PER_SECOND;

    private final Game view; 
    private boolean running = false; 

    public GameLoopThread(Game view) {
        this.view = view;
    }

    public void setRunning(boolean run) {
        running = run;
    }

    @Override
    public void run()
    {
        long startTime;
        long sleepTime;

        while (running)
        {
            startTime = System.currentTimeMillis();

            synchronized (view.getHolder()) {view.update();}

            Canvas c = null;
            try {
                c = view.getHolder().lockCanvas();
                synchronized (view.getHolder()) {view.draw(c);}
            }
            finally
            {
                try {
                    if (c != null) {
                        view.getHolder().unlockCanvasAndPost(c);
                    }
                } catch(IllegalArgumentException iae) { iae.printStackTrace(); }
            }
            sleepTime = SKIP_TICKS-(System.currentTimeMillis() - startTime);
            try {
                if (sleepTime >= 0) {sleep(sleepTime);}
            }
            catch (Exception e) {}
        } 
    } 

}