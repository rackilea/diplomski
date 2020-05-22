import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Chooser {
    static File cavia;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { // All swing applications should run in their own thread
            JFrame quadro = new JFrame();
            JFileChooser scelta = new JFileChooser();
            quadro.setLayout(new GridLayout());
            JButton apriselezione = new JButton("Selezionafle");
            quadro.setBounds(20, 20, 300, 300);
            scelta.setCurrentDirectory(
                    new File(System.getProperty("user.home") + System.getProperty("file.separator") + "Desktop"));

            apriselezione.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    scelta.showOpenDialog(apriselezione);
                    cavia = scelta.getSelectedFile();
                    try (FileReader testo = new FileReader(cavia)) { // try-with-resources
                    //Do something with filereader
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            });
            apriselezione.setVisible(true);
            quadro.add(apriselezione);
            quadro.setVisible(true);
            quadro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}