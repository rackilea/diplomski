import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ImageButton extends JButton {

private String fileName;
private ImageIcon image;
private JButton button;

public ImageButton(String fileName) {

    setFileName(fileName);
    setImage(new ImageIcon(fileName));
    setButton(new JButton(getImage()));

    this.setIcon(getImage());

    this.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {

            JOptionPane.showMessageDialog(null, ae.getSource());
        }
    });

}

public String getFileName() {
    return fileName;
}

public void setFileName(String fileName) {
    this.fileName = fileName;
}

public ImageIcon getImage() {
    return image;
}

public void setImage(ImageIcon image) {
    this.image = image;
}

public JButton getButton() {
    return button;
}

public void setButton(JButton button) {
    this.button = button;
}

}