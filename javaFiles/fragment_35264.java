package hello;

import org.springframework.stereotype.Component;

@Component
public class MyTask implements Runnable {

    @Override
    public void run() {
        //complicated stuff
    }
}