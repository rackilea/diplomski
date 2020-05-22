import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

class MyFrame extends JFrame {

    public MyFrame() {
        JPanel panel = new JPanel(new GridBagLayout());

        JLabel image = new JLabel();
        image.setIcon(new ImageIcon(getClass().getResource("/image.png")));

        JLabel question = new JLabel("3 + 3 = ?");

        JRadioButton rb1 = new JRadioButton("5");
        JRadioButton rb2 = new JRadioButton("3");
        JRadioButton rb3 = new JRadioButton("6");
        JRadioButton rb4 = new JRadioButton("9");
        JRadioButton rb5 = new JRadioButton("23");

        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;//set the x location of the grid for the next component
        c.gridy = 0;//set the y location of the grid for the next component
        panel.add(image,c);

        c.gridy = 1;//change the y location
        c.anchor=GridBagConstraints.WEST;//left align components after this point
        panel.add(question,c);

        c.gridy = 2;//change the y location
        panel.add(rb1,c);

        c.gridy = 3;//change the y location
        panel.add(rb2,c);

        c.gridy = 4;//change the y location
        panel.add(rb3,c);

        c.gridy = 5;//change the y location
        panel.add(rb4,c);

        c.gridy =6;//change the y location
        panel.add(rb5,c);

        this.getContentPane().add(panel);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
    }

    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
        myFrame.setVisible(true);
    }

}