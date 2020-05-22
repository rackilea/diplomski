import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainWindow extends JFrame {

    private static final long serialVersionUID = 1L;


    public MainWindow() throws IOException {
        // name of window
        this.setTitle("BlueNect");
        // size of the window
        this.setSize(300, 300);
        // to not resize the window
        this.setResizable(false);
        JButton button = new JButton("Test Notif");
        button.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              new PopUpMessage().makeUI("0679149407","azertyu iopqsdf ghjklmw xcvbnaze rtyu iopqsdfghjk lmwxcvbn azertyu iopqsdf ghjklmw xcvbnaze rtyu iopqsdfghjk lmwxcvbn azertyu iopqsdf ghjklmw xcvbnaze rtyu iopqsdfghjk lmwxcvbn azertyu iopqsdf ghjklmw xcvbnaze rtyu iopqsdfghjk lmwxcvbn azertyu iopqsdf ghjklmw xcvbnaze rtyu iopqsdfghjk lmwxcvbn");
              //new PartialFrame().makeUI("0679149407","azertyu iopqsdf ghjklmw xcvbnaze rtyu iopqsdfghjk");
          }
        });
        this.getContentPane().add(button);
        // close safely the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // put the window on the center of the display
        this.setLocationRelativeTo(null);
        // set the window visible
        this.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            new MainWindow();
        } catch (IOException e) {
            e.printStackTrace();
        }

      }
}