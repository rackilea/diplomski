import javax.swing.*;

public class SimpleThreeTierMain {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // Doing some stuff here, like building rooms, etc...

        // Here I start using images
        DrawRoom drawRoom = new DrawRoom();
        JFrame  frame;

        frame = new JFrame("The Current Image");
        frame.setContentPane(drawRoom);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640,510);
        frame.setVisible(true);

        // Then in a while loop, I get user input from the console and process it.
        // According to which room the user is in, I want to draw the corresponding
        //image.

         long  lTime = 2050;
        int   iChange = 0;
        try {
            while (true) {
                Thread.sleep (lTime);
                if (iChange == 1)
                    drawRoom.changeImage("0112091252a.jpg");
                else
                    drawRoom.changeImage("0112091251.jpg");
                iChange = 1 - iChange;
            }
        } catch (InterruptedException iex) {}
    }
}