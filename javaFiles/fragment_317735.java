import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestCard {

    public static void main(String[] args) {
        new TestCard();
    }

    public TestCard() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                final CardLayout cardLayout = new CardLayout();
                final JPanel cardPane = new JPanel(cardLayout);
                cardPane.add(new Card01(), "Card01");
                cardPane.add(new Card02(), "Card02");

                JToggleButton btnCard01 = new JToggleButton("#1");
                JToggleButton btnCard02 = new JToggleButton("#2");
                ButtonGroup bg = new ButtonGroup();
                bg.add(btnCard01);
                bg.add(btnCard02);
                JPanel buttons = new JPanel();
                buttons.add(btnCard01);
                buttons.add(btnCard02);

                btnCard01.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cardLayout.show(cardPane, "Card01");
                    }
                });
                btnCard02.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cardLayout.show(cardPane, "Card02");
                    }
                });
                btnCard01.setSelected(true);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(cardPane);
                frame.add(buttons, BorderLayout.SOUTH);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class Card01 extends JPanel {

        public Card01() {
            setLayout(new GridBagLayout());
            add(new JLabel("#1"));
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }
    }

    public class Card02 extends JPanel {

        public Card02() {
            setLayout(new GridBagLayout());
            add(new JLabel("#2"));
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }
    }

}