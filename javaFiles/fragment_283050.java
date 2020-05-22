package test;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Pinger {

    /**
     * @param args
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Pinger pinger = new Pinger();
                JFrame frame = new JFrame();
                JPanel panel = new JPanel();
                frame.setSize(300, 400);
                frame.add(panel);
                JTextArea textArea = new JTextArea();
                panel.add(textArea);
                frame.setVisible(true);
                pinger.executor.execute(pinger.createRunnable("google.com",
                        textArea));
            }
        });

    }

    private Runnable createRunnable(final String ip, final JTextArea area) {
        return new Runnable() {
            public void run() {
                String resposta = "";
                String comando = "ping -t " + ip;

                try {
                    Scanner S = new Scanner(Runtime.getRuntime().exec(comando)
                            .getInputStream());
                    while (S.hasNextLine()) {
                        final String newText = S.nextLine();
                        EventQueue.invokeLater(new Runnable() {
                            public void run() {
                                area.setText(area.getText()
                                        + System.getProperty("line.separator")
                                        + newText);
                            }
                        });

                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        };
    }

    Executor executor = Executors.newFixedThreadPool(1);

}