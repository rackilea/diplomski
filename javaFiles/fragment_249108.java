package com.test.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PingParallel {

    public static void main(String[] args) {
        int totalIps = 89;
        ExecutorService executor = Executors.newFixedThreadPool(totalIps);
        List<Future<PingResult>> list = new ArrayList<Future<PingResult>>();
        Callable<PingResult> callable = null;
        for(int i=0; i< totalIps; i++){
            callable = new PingTask("127.0.0"+i); // Get the ipAddres buttons[i].getText());
            Future<PingResult> future = executor.submit(callable);
            list.add(future);
        }
        for(Future<PingResult> fut : list){
            try {
                System.out.println(new Date()+ "::"+fut.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}