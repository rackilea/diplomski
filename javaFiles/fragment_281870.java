package com.test;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class StopWatch 
{
    public static int interval;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input seconds => : ");
        interval = input.nextInt();
        int delay = 1000;
        int period = 1000;
        final Timer time = new Timer();
        System.out.println(interval);
        time.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                if (interval == 0) {
                    System.out.println("work finished");
                    time.cancel();
                    time.purge();
                } else {
                    System.out.println(setInterval());
                }
            }
        }, delay, period);
    }

    private static int setInterval() {

        return --interval;
    }

}