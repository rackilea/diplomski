import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

public class Test {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel container = new JPanel(new MigLayout("fill, gapx 2", "grow"));
        container.add(new JLabel("Header", SwingConstants.CENTER), "split, span, growx, wrap");

        JLabel shrinkMeIfYouNeedTo = new JLabel("Shrink Shrink");
        container.add( shrinkMeIfYouNeedTo, "growx, width 0:0:100");
        container.add( new JLabel("Great, long, beautiful info text that shall never shrink"), "growx");

        JScrollPane scrollPane = new JScrollPane(container);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        frame.add(scrollPane);
        frame.setPreferredSize(new Dimension(800, 100));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}