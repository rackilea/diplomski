package so;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashSet;

public class CrazyClass {

    static class RunMe implements Runnable{

        @Override
        public void run() {
            try {
                Files.walk(FileSystems.getDefault().getPath("....."))
                .mapToLong(path -> path.toFile().length())
                .peek(e -> {
                        if (Thread.currentThread().isInterrupted()) {
                            throw new RuntimeException("Interruption requested");
                        }
                })
                .sum();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }


    }
    public static void main(String[] args) {
        Thread th = new Thread(new RunMe());
        th.start();
        try{
            while(th.getState() == Thread.State.RUNNABLE){
                th.interrupt();
                Thread.sleep(100);
            }
        }
        catch(Exception x){

        }
    }
}