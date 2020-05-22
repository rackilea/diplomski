import javax.swing.*;
import java.awt.*;

public class Main2 {

    private static JFrame frame;

    Main2() {
        frame = new JFrame();

        JTabbedPane jTabbedPane = new JTabbedPane();
        jTabbedPane.setBorder(null);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        panel1.setLayout( new FlowLayout() );
        JPanel child = new JPanel();
        child.setPreferredSize( new Dimension(100, 100) );
        child.setBackground( Color.WHITE );
        panel1.add( child );

        panel1.setPreferredSize(new Dimension(400, 400));
        panel2.setPreferredSize(new Dimension(500, 600));
        panel3.setPreferredSize(new Dimension(100, 100));

        //panel1.setBackground(Color.WHITE);
        panel2.setBackground(Color.RED);
        panel3.setBackground(Color.GREEN);

        panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        panel3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        jTabbedPane.addTab("Tab1", panel1);
        jTabbedPane.addTab("Tab2", panel2);
        jTabbedPane.addTab("Tab3", panel3);

        frame.setLayout( new FlowLayout() );
        frame.add(jTabbedPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);
        frame.setLocationRelativeTo(null);
    }


    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main2 main = new Main2();
                frame.setVisible(true);
            }
        });
    }
}