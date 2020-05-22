import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MP3 {

    private final String filename;

    private ExecutorService executorService;
    private Player player;

    public MP3(String filename) {
        this.filename = filename;
    }

    public void play() {
        try {
            FileInputStream fis = new FileInputStream(filename);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new Player(bis);
            player.play();
        } catch (Exception e) {
            System.out.println("Problem playing file " + filename);
            e.printStackTrace();
        }
    }

    public void playAsync() {
        if (executorService == null) {
            executorService = Executors.newSingleThreadExecutor();
            executorService.submit(this::play);
        }
    }

    public void playForever() {
        while (true) {
            sleep();
            if (player == null || player.isComplete()) {
                System.out.println("Still playing: " + filename);
                stopAsync();
                playAsync();
            }
        }
    }

    public void stopAsync() {
        if (player != null) {
            player.close();
            player = null;
        }
        if (executorService != null) {
            executorService.shutdown();
            executorService = null;
        }
    }

    private void sleep() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}