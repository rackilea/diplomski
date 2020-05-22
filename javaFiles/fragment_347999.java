import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CardTest implements ActionListener {

    private JPanel cards;
    private JButton button1;
    private JButton button2;

    public void addComponentToPane(Container pane) {
        // create cards
        JPanel card1 = new JPanel();
        JPanel card2 = new JPanel();
        button1 = new JButton("Button 1");
        button2 = new JButton("Button 2");
        button1.addActionListener(this);
        button2.addActionListener(this);
        card1.add(button1);
        card2.add(button2);

        // create panel that contains cards
        cards = new JPanel(new CardLayout());
        cards.add(card1, "Card 1");
        cards.add(card2, "Card 2");
        pane.add(cards, BorderLayout.CENTER);
    }

    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, (String) evt.getItem());
    }

    public static void createAndShowGUI() {
        // create and setup window
        JFrame frame = new JFrame("Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create and setup content pane
        CardTest main = new CardTest();
        main.addComponentToPane(frame.getContentPane());

        // display window
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == button1) {

            CardLayout cl = (CardLayout) (cards.getLayout());
            cl.show(cards, "Card 2");

        } else if (ae.getSource() == button2) {

            CardLayout cl = (CardLayout) (cards.getLayout());
            cl.show(cards, "Card 1");
        }
    }

    public static void main(String[] args) {
        // set look and feel
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        // turn off metal's bold fonts
        UIManager.put("swing.boldMetal", Boolean.FALSE);

        // schedule job for the event dispatch thread creating and showing GUI
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}