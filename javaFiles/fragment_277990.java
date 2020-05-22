package de.hotware.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    private Pause mPause;

    public Test() {
        this.mPause = new Pause();
    }

    public void concurrent() throws InterruptedException {
        while(true) {
            this.mPause.probe();
            System.out.println("concurrent");
            Thread.sleep(100);
        }
    }

    public void crucial() throws InterruptedException {
        int i = 0;
        while (true) {
            if (i++ % 2 == 0) {
                this.mPause.pause(true);
                System.out.println("crucial: exclusive execution");
                this.mPause.pause(false);
            } else {
                System.out.println("crucial: normal execution");
                Thread.sleep(1000);
            }
        }
    }

    public static void main(String[] args) {
        final Test test = new Test();
        Runnable run = new Runnable() {

            @Override
            public void run() {
                try {
                    test.concurrent();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        };
        Runnable cruc = new Runnable() {

            @Override
            public void run() {
                try {
                    test.crucial();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        };
        ExecutorService serv = Executors.newCachedThreadPool();
        serv.execute(run);
        serv.execute(run);
        serv.execute(cruc);
    }

}