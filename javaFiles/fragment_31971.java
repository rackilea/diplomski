import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gui extends JFrame {

private static final long serialVersionUID = 1L;
private final JPanel contentPane;
private JLabel BackgroundLabel;
Image background;


/**
 * Launch the application.
 */
public static void main(final String[] args) {
    EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            try {
                final Gui frame = new Gui();
                frame.setVisible(true);
            } catch (final Exception e) {
                e.printStackTrace();
            }
        }
    });
}


/**
 * Create the frame.
 */
public Gui() {
    this.setTitle("Exile Launcher");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setBounds(100, 100, 1000, 563);
    this.contentPane = new JPanel();
    this.contentPane.setBorder(null);
    this.setContentPane(this.contentPane);
    this.contentPane.setLayout(null);

    try {
        this.background = ImageIO.read(new File("src/Images/Background.jpg"));
    } catch (final IOException e) {
        e.printStackTrace();
    }

    final JLabel backgroundLabel = new JLabel(new ImageIcon(this.background));
    backgroundLabel.setBounds(new Rectangle(0, 0, 1000, 563));
    this.add(backgroundLabel);

    final JButton HomeButton = new JButton("Home");
    HomeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(final ActionEvent e) {
            try {
                Desktop.getDesktop().browse(new URL("http://www.google.nl").toURI());
            } catch (final MalformedURLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (final IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (final URISyntaxException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    });

    HomeButton.setBounds(10, 9, 50, 50);
    this.contentPane.add(HomeButton);

    final JButton ForumButton = new JButton("Vote");
    ForumButton.setBounds(10, 70, 50, 50);
    this.contentPane.add(ForumButton);

    final JButton VoteButton = new JButton("New button");
    VoteButton.setBounds(10, 131, 50, 50);
    this.contentPane.add(VoteButton);
}


// Final Piece to add an image to the jpanel
public void paintComponent(final Graphics pic) {
    this.paintComponent(pic);
    pic.drawImage(this.background, 0, 0, null);
}
}