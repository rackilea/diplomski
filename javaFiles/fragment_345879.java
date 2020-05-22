import javax.swing.*;
import java.awt.*;

public class TestMaxWidthFlowLayout {

    public static void main(String[] args) {
        JFrame f=new JFrame();
        JPanel pButtons=new JPanel(new FlowLayout() {
            public Dimension preferredLayoutSize(Container target) {
                Dimension sd=super.preferredLayoutSize(target);

                sd.width=Math.min(200, sd.width);

                return sd;
            }
        });
        for (int i=0;i<20; i++) {
            pButtons.add(new JButton("b-"+i));
        }

        f.add(pButtons, BorderLayout.WEST);
        f.add(new JLabel("center"), BorderLayout.CENTER);

        f.setSize(500, 300);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}