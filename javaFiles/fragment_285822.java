import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.AbstractDocument.Content;

public class View extends JFrame {

    private static final long serialVersionUID = 1L;
    private static final float DIM_WIDTH = 2661f;
    private static final float DIM_HEIGHT = 800; //R1663f;
    final Dimension SIZE = new Dimension(Math.round(DIM_WIDTH), Math.round(DIM_WIDTH));

    /**
     * @return the pre-determined size of the JFrame
     */
    public Dimension getDimensionSize() {
        return SIZE;
    }

    public View() {
        setTitle("Warframe Alert/Invasion Tracker - Project 4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        createPanel();
        pack();
        setLocation(0, 0);
        setVisible(true);
    }

    public void createPanel() {
        JTextPane textPane = new JTextPane();
        Font font = new Font("Apple Casual", Font.PLAIN, 35);
        textPane.setEditable(false);
//        textPane.setBackground(new Color(0, 200, 255, 50));
        textPane.setBackground(new Color(0, 204, 255)); // web safe 
//        textPane.setText(Content.getAlertText()); //Content class is a class that creates the content to show on the textPane
        textPane.setText("1234567890\n1234567890\n1234567890\n1234567890\n1234567890\n1234567890\n1234567890\n1234567890\n1234567890\n1234567890\n1234567890\n1234567890\n1234567890\n1234567890\n1234567890\n1234567890\n1234567890\n1234567890\n1234567890\n1234567890\n1234567890\n1234567890\n1234567890\n1234567890\n1234567890\n1234567890\n1234567890\n1234567890\n1234567890\n1234567890\n1234567890\n1234567890\n1234567890\n1234567890\n1234567890\n1234567890\n1234567890\n1234567890\n1234567890\n");
        textPane.setForeground(Color.black);
        textPane.setFont(font);

        JScrollPane scrollPane = new JScrollPane(textPane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(50, 50, Math.round(DIM_HEIGHT * 0.8f), Math.round(DIM_HEIGHT * 0.8f));

        JLabel background = new JLabel(new ImageIcon("..\\Project 4\\img\\bg.jpg"));
        background.setBounds(0, 0, Math.round(DIM_WIDTH), Math.round(DIM_HEIGHT));

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(getDimensionSize());
        layeredPane.add(background);
        layeredPane.add(scrollPane);

        this.getContentPane().add(layeredPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new View();
    }
}