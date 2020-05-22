import javazoom.jl.player.Player;
import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.util.Random;

public class MainClass {
    UI ui = new UI();

    public MainClass() throws InterruptedException {
        String mp3Url = "url of MP3-File";
        int sleepMillisec = 100;
        int i = 600;

        ui.player(mp3Url);


        ui.flash(i, sleepMillisec);
    }

    public static void main(String[] args) throws InterruptedException {
        new MainClass();
    }

    public class UI {
        JFrame window;
        Container con;

        public void player(String mp3Url) {

            new Thread(new Runnable(){
                public void run() {

                    try {
                        FileInputStream fis = new FileInputStream(mp3Url);
                        Player playMP3 = new Player(fis);

                        playMP3.play();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        System.exit(-1);
                    }
                }
            }).start();

            /*
            try {

                FileInputStream fis = new FileInputStream(mp3Url);
                Player playMP3 = new Player(fis);

                playMP3.play();

            } catch (Exception e) {
                System.out.println(e);
            }

             */
        }

        public void flash(int i, int sleepMillisec) throws InterruptedException {

            window = new JFrame();
            window.setSize(800, 550);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.getContentPane().setBackground(Color.black);
            window.setLayout(null);
            con = window.getContentPane();

            for (int k = 0; k < i; k++) {
                Thread.sleep(sleepMillisec);

                Random diceColor = new Random();
                int randomColorBg = diceColor.nextInt(2);
                switch (randomColorBg) {
                    case 0:
                        window.getContentPane().setBackground(Color.yellow);
                        break;
                    case 1:
                        window.getContentPane().setBackground(Color.black);
                        break;
                }
                window.setVisible(true);
                con.setVisible(true);
            }
        }
    }
}