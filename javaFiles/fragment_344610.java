import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lab2 extends JFrame {

Lab2(){
    setTitle("Lab 1b - Application #2");
    Lab2Panel p = new Lab2Panel();
    add(p);
}

public static void main(String[] args){

    Lab2 frame = new Lab2();
    frame.setTitle("Lab2 Application # 1");
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200, 400);
    frame.setVisible(true);
    }

}

class Lab2Panel extends JPanel{
Lab2Button canvas = new Lab2Button();
JPanel panel = new JPanel();

Lab2Panel () {

    setLayout(new BorderLayout());

    JButton leftButton = new JButton("left");
    JButton rightButton = new JButton("right");
    JButton upButton = new JButton("up");
    JButton downButton = new JButton("down");

    panel.add(leftButton);
    panel.add(rightButton);
    panel.add(upButton);
    panel.add(downButton);

    this.add(canvas, BorderLayout.CENTER);
    this.add(panel, BorderLayout.SOUTH);

    leftButton.addActionListener(new Lab2MoveBallListener(canvas));
}


}

class Lab2Button extends JPanel {
int radius = 5;
int x = -1;
int y = -1;

protected void paintComponent(Graphics g){
    if (x<0 || y<0) {
        x = getWidth() / 2 - radius;
        y = getHeight() / 2 - radius;
    }
    super.paintComponent(g);
    g.drawOval(x,y, 2 * radius, 2 * radius);

}

        public void moveLeft(){

            //this.add(this, BorderLayout.WEST);
            x -= 5;
            this.repaint();
        }


}

class Lab2MoveBallListener implements ActionListener{
    private Lab2Button canvas;

Lab2MoveBallListener(Lab2Button canvas) {
    this.canvas = canvas;
}

public void actionPerformed(ActionEvent e){
    canvas.moveLeft();
}
}