import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Test extends JButton implements ActionListener{

    private static final long serialVersionUID = 1L;
    Image img;

        /**  constuctor     **/
    public Test(String tImg, JFrame parent){
        this.img = new ImageIcon(tImg).getImage();
        this.addActionListener(this);

    }


           /***********    this is the function you want to learn  ***********/
    @Override
    public void paint(Graphics g){
        g.drawImage(this.img, 0, 0, null);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO do some stuff when its clicked
        JOptionPane.showMessageDialog(null, "you clicked the button");
    }




    public static void main(String[] args) {
        JFrame f = new JFrame();
        Test t = new Test("pics.gif", f);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(1, 1));
        f.add(t);
        f.setSize(400,600);
        f.setVisible(true);
    }

}