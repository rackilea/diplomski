import java.awt.BorderLayout;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class ChangeButtonIcon extends JPanel{

    private final URL[] urls = {
            new URL("https://findicons.com/files/icons/345/summer/128/cake.png"),
            new URL("http://icons.iconarchive.com/icons/atyourservice/service-categories/128/Sweets-icon.png"),
            new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_FkBgG3_ux0kCbfG8mcRHvdk1dYbZYsm2SFMS01YvA6B_zfH_kg"),
    };

    private int iconNumber = 0;
    private final JButton button;
    private boolean stop = true;
    private final Random random;
    private static final int MIN_DELAY = 70, DELAY = 500;
    private Timer timer;

    public ChangeButtonIcon() throws IOException {

        random = new Random();
        button = new JButton();
        button.setIcon(new ImageIcon(urls[iconNumber]));
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.addActionListener(e -> startStopSlideShow());
        add(button);
    }

    private void startStopSlideShow(){

        stop = ! stop;
        if(stop){
            timer.stop();
            return;
        }

        timer = new Timer( MIN_DELAY+ random.nextInt(DELAY), (e)->swapIcon());
        timer.start();
    }

    private void swapIcon() {
        iconNumber = iconNumber >= urls.length -1 ? 0 : iconNumber+1;
        button.setIcon(new ImageIcon(urls[iconNumber]));
    }

    public static void main(String[] args) throws IOException{
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(new ChangeButtonIcon());
        window.add(new JLabel("Click image to start / stop"), BorderLayout.PAGE_END);
        window.pack();
        window.setVisible(true);
    }
}