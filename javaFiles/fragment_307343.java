import javax.swing.*;
import java.awt.*;
public class Test extends JFrame {
Test() {
    setSize(1000, 500);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    getContentPane().setLayout(new FlowLayout());
    Test2 test2=new Test2();
    JScrollPane scrollableLine = new JScrollPane(test2);
scrollableLine.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    scrollableLine.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    setContentPane(scrollableLine);
    setVisible(true);
}

public static void main(String[] args) {
    new Test();
}
}

class Test2 extends JPanel {

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawLine(100, 100, 2000, 100);

}
@Override
public Dimension getPreferredSize() {
    return new Dimension(3000, 3000);
}

}