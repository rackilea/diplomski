package example;

import java.io.PrintStream;

public class ConsoleToGUI {

    public ConsoleToGUI() {
        GUI gui = new GUI();
        System.setOut(new PrintStream(new RedirectingOutputStream(gui), true));
        gui.start();
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Test program");
        }
    }

    public static void main(String[] args) {
        ConsoleToGUI ctg = new ConsoleToGUI();
        ctg.run();
    }
}