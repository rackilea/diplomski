import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class TestLayout {

    int width = 680;
    int x = 30;

    public void createUI(){
        JFrame frame = new JFrame("Test JLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        JPanel mainPanel = new JPanel();

        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        frame.add(mainPanel,BorderLayout.CENTER);

        //=========Add panel and specific strut on mainPanel============

        mainPanel.add(new APanel());

        mainPanel.add(Box.createVerticalStrut(15));

        mainPanel.add(new BPanel());

        mainPanel.add(Box.createVerticalStrut(15));

        mainPanel.add(new CPanel());

        mainPanel.add(Box.createVerticalStrut(20));

        mainPanel.add(new DPanel());


        //==========================done================================


        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                TestLayout testLayout = new TestLayout();
                testLayout.createUI();

            }
        });
    }

    @SuppressWarnings("serial")
    class APanel extends JPanel{
        public APanel(){
            setBackground(new Color(100, 200, 100,100));
            setBorder(BorderFactory.createLineBorder(Color.black));
            setPreferredSize(new Dimension(width, 6*x - 5));

            HorizontalPanel horizontalBoxPanel = new HorizontalPanel();


            JPanel gridlayoutPanel = new JPanel();
            gridlayoutPanel.setLayout(new GridLayout(2, 2));
            JLabel label1 = new JLabel("label1");
            label1.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
            JLabel label2 = new JLabel("label2");
            JTextField textField1 = new JTextField(20);
            JTextField textField2 = new JTextField(20);
            gridlayoutPanel.add(label1);
            gridlayoutPanel.add(textField1);
            gridlayoutPanel.add(label2);
            gridlayoutPanel.add(textField2);

            add(horizontalBoxPanel,BorderLayout.NORTH);
            add(gridlayoutPanel,BorderLayout.CENTER);
        }
    }

    @SuppressWarnings("serial")
    class BPanel extends JPanel{
        public BPanel(){
            setBackground(new Color(100, 200, 100, 100));
            setBorder(BorderFactory.createLineBorder(Color.black));
            setPreferredSize(new Dimension(width, 2*x));

            HorizontalPanel horizontalBoxPanel = new HorizontalPanel();

            add(horizontalBoxPanel,BorderLayout.CENTER);

        }
    }

    @SuppressWarnings("serial")
    class CPanel extends JPanel{
        public CPanel(){
            setBackground(new Color(100, 200, 100, 100));
            setBorder(BorderFactory.createLineBorder(Color.black));
            setPreferredSize(new Dimension(width, x));

            JButton button = new JButton("Button");
            button.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            button.setPreferredSize(new Dimension(200, 20));
            add(button,BorderLayout.CENTER);
        }
    }

    @SuppressWarnings("serial")
    class DPanel extends JPanel{
        public DPanel(){
            setBackground(new Color(100, 200, 100, 100));
            setBorder(BorderFactory.createLineBorder(Color.black));
            setPreferredSize(new Dimension(width, 6*x - 5));

            JLabel label = new JLabel("It's a label");
            label.setFont(new Font("Arial", Font.BOLD, 120));
            add(label,BorderLayout.CENTER);
        }
    }

    @SuppressWarnings("serial")
    class HorizontalPanel extends JPanel{
        public HorizontalPanel(){
            setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            JRadioButton radioButton = new JRadioButton();
            add(radioButton);
            setBackground(new Color(100, 200, 100, 0));
            add(Box.createHorizontalStrut(650));
            setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        }
    }

}