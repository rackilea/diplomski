import java.awt.*;
import javax.swing.*;

public class TestCornerComponent {

    public static void main(String args[])
    {
        final JScrollPane scrollPane = new JScrollPane();

        /* button to put in corner */
        JButton cornerButton = new JButton("#");
        scrollPane.setCorner(JScrollPane.UPPER_TRAILING_CORNER, cornerButton);

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel column = new JPanel();
        column.setPreferredSize( new Dimension(100, cornerButton.getPreferredSize().height) );
        scrollPane.setColumnHeaderView( column );

        JPanel view = new JPanel();
        view.setPreferredSize( new Dimension(100, 100) );
        scrollPane.setViewportView( view );

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                JFrame frame = new JFrame("Test corner component");
                frame.add(scrollPane);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}