import java.awt.*;
import javax.swing.*;
import java.io.File;
import javax.imageio.ImageIO;

// Class. public class <nameOfFile>
public class GAC extends JPanel {
    // Main class.
    public static void main(String[] args) {
        drawGUI();
    }

    // Method to create GUI
    public static void drawGUI() {
        // Create a new JFrame and name it 'f'.
        JFrame f = new JFrame("Griffin Account Cracker - Java Edition");

        // Set the size of the new GUI.
        f.setPreferredSize(new Dimension(600, 785));

        // add a panel to the frame - the background image will be drawn on the panel
        GAC t = new GAC();
        t.setVisible(true);
        f.add(t);

        // Tell the GUI to exit whenever the 'x' button is pressed.
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the GUI visible.
        f.setVisible(true);
        f.pack();
        f.repaint();
    }

    // Method to set GUI's background color.
    @Override
    public void paintComponent(Graphics f) {
        //good practice to call this
        super.paintComponent(f);

        //color the background
        f.setColor(Color.decode("#A0A0A4"));
        f.fillRect(0, 0, this.getWidth(), this.getHeight());

        //we need this try block to handle file reading errors
        try {
            //get the image from a file and scale it to the size you want
            String guiBanner = "Images/Logo.jpg";
            Image guiBannerImg = ImageIO.read(new File(guiBanner)).getScaledInstance(480, 270, Image.SCALE_SMOOTH);

            //draw it at the position you want
            f.drawImage(guiBannerImg, 25, 25, null);
        } catch (Exception e) {
        }
    }
}