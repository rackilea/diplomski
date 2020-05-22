import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;

/** @see http://stackoverflow.com/a/10610126/230513 */
public class AlignImage extends JPanel {

    private JPanel controlPanel = new JPanel();
    private JLabel imageLabel;

    public AlignImage() {
        super(new GridLayout());
        try {
            imageLabel = new JLabel(new ImageIcon(new URL(
                "http://sstatic.net/stackoverflow/img/logo.png")));
        } catch (MalformedURLException ex) {
            ex.printStackTrace(System.err);
        }
        this.add(imageLabel);
        controlPanel.add(new JButton(new AbstractAction("Align Left") {

            @Override
            public void actionPerformed(ActionEvent e) {
                align(JLabel.LEFT);
            }
        }));
    }

    @Override
    public Dimension getPreferredSize() {
        int w = 3 * imageLabel.getIcon().getIconWidth() / 2;
        int h = 3 * imageLabel.getIcon().getIconHeight() / 2;
        System.out.println(w + " " + h);
        return new Dimension(w, h);
    }

    private void align(int alignment) {
        imageLabel.setHorizontalAlignment(alignment);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame f = new JFrame("Align Left");
                f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                AlignImage ai = new AlignImage();
                f.add(ai, BorderLayout.CENTER);
                f.add(ai.controlPanel, BorderLayout.SOUTH);
                f.pack();
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        });

    }
}