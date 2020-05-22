import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class BoxLabels {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                Box box = Box.createVerticalBox();
                Font font = new Font("monospaced", Font.PLAIN, 11);

                JPanel sideBar = new JPanel();
                sideBar.setBackground(Color.BLACK);
                sideBar.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
                sideBar.add(box);

                JTextArea text = new JTextArea(15, 50);
                text.setMargin(new Insets(5, 5, 5, 5));
                text.setBackground(Color.darkGray);
                text.setForeground(Color.white);
                text.setFont(font);

                int count = 1;
                for (int i = 0; i < 10; i++) {
                    JLabel label = new JLabel(String.valueOf(count));
                    label.setFont(font);
                    label.setForeground(Color.GREEN);
                    box.add(label);
                    count++;
                }

                JPanel panel = new JPanel(new BorderLayout());
                panel.add(text);
                panel.add(sideBar, BorderLayout.WEST);

                JOptionPane.showMessageDialog(null, panel);
            }
        });
    }
}