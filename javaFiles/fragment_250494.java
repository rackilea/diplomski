package com.coralblocks.corallog.bench;

import java.io.File;
import java.nio.ByteBuffer;

import com.coralblocks.corallog.AsyncThread;
import com.coralblocks.corallog.Log;
import com.coralblocks.corallog.Logger;

public class PerformanceTest4 {

    public static void main(String[] args) throws Exception {

        int batchSize = Integer.parseInt(args[0]);
        int passes = Integer.parseInt(args[1]);
        int msgSize = Integer.parseInt(args[2]);

        byte[] msgBytes = new byte[msgSize];

        // build a dummy message:
        for(int i = 0; i < msgBytes.length; i++) {
             msgBytes[i] = (byte) String.valueOf(i % 10).charAt(0);
        }

        ByteBuffer bb = ByteBuffer.wrap(msgBytes);

        Log.setIncludeTopHeader(false);

        String dir = ".";
        String filename = "throughput.log";

        Logger logger;
        boolean isMmap = System.getProperty("logMemoryMappedFile", "true").equals("true");

        if (isMmap) {
            logger = Log.createMemoryMappedLogger(dir, filename, null /* no timestamps */, false /* not synchronized */, true /* asynchronous */);
        } else {
            logger = Log.createLogger(dir, filename, null, false, true);
        }

        int count = 0;

        while(count < passes) {

            long start = System.nanoTime();

            for(int i = 0; i < batchSize; i++) {
            bb.position(0);
            logger.log(bb);
            }

            long time = System.nanoTime() - start;

            double seconds = (((double) time) / 1000000000L);

            System.out.println("Batch " + (count + 1) + " took: " + seconds + " s");

            count++;
        }

        logger.drainCloseAndWait();

        boolean deleteFile = System.getProperty("deleteFile", "true").equals("true");

        if (deleteFile) {
            File f = new File(dir, filename);
            f.delete();
        }

        AsyncThread.drainAndDie(); // just so the vm will exit... (async thread is not daemon)
    }
}