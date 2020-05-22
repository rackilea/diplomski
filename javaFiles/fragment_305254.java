import java.awt.Component;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;

    public class ActionListeners implements ActionListener {

        public void actionPerformed(ActionEvent B) {

            CodeGui Gui = new CodeGui();

            if (Gui.num1.getName().equals(((Component) B.getSource()).getName())) {
                // LevelChanger.buttoncount++;
                LevelChanger.incButtonCount(1);
            }
            if (Gui.num2.getName().equals(((Component) B.getSource()).getName())) {
                // LevelChanger.buttoncount += 2;
                LevelChanger.incButtonCount(2);
            }
            if (Gui.num3.getName().equals(((Component) B.getSource()).getName())) {
                // LevelChanger.buttoncount += 3;
                LevelChanger.incButtonCount(3);
            }
            if (Gui.num4.getName().equals(((Component) B.getSource()).getName())) {
                // LevelChanger.buttoncount += 4;
                LevelChanger.incButtonCount(4);
            }
            if (Gui.num5.getName().equals(((Component) B.getSource()).getName())) {
                // LevelChanger.buttoncount += 5;
                LevelChanger.incButtonCount(5);
                // System.out.println(LevelChanger.buttoncount);
            }

        }
    }


    // ===== //


    import java.awt.Color;
    import java.awt.Font;

    import javax.swing.*;
    import javax.swing.border.EmptyBorder;

    public class CodeGui extends JFrame {
        private static final long serialVersionUID = 1L;

        ActionListeners Al = new ActionListeners();

        protected JPanel contentPane;

        JTextArea questionArea, hintArea;
        JLabel livesleft, lblLevel, Maxbutclick;
        final JButton num1, num2, num3, num4, num5;

        public CodeGui() {

            setTitle("The Code Game");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 602, 411);
            setResizable(false);
            contentPane = new JPanel();
            contentPane.setBackground(Color.BLACK);
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);

            livesleft = new JLabel("Lives Left : " + LevelChanger.lives);
            livesleft.setFont(new Font("Stencil Std", Font.BOLD | Font.ITALIC, 14));
            livesleft.setForeground(Color.WHITE);
            livesleft.setBounds(10, 347, 126, 14);
            contentPane.add(livesleft);

            lblLevel = new JLabel("level : " + LevelChanger.level);
            lblLevel.setFont(new Font("Stencil Std", Font.BOLD | Font.ITALIC, 14));
            lblLevel.setForeground(Color.WHITE);
            lblLevel.setBounds(468, 347, 108, 14);
            contentPane.add(lblLevel);

            ActionListeners buttonL = new ActionListeners();

            num1 = new JButton("1");
            num1.setBounds(10, 229, 89, 23);
            num1.setName("button1");
            num1.addActionListener(buttonL);
            contentPane.add(num1);

            num2 = new JButton("2");
            num2.setBounds(128, 229, 89, 23);
            num2.setName("button2");
            num2.addActionListener(buttonL);
            contentPane.add(num2);

            num3 = new JButton("3");
            num3.setBounds(248, 229, 89, 23);
            num3.setName("button3");
            num3.addActionListener(buttonL);
            contentPane.add(num3);

            num4 = new JButton("4");
            num4.setBounds(374, 229, 89, 23);
            num4.setName("button4");
            num4.addActionListener(buttonL);
            contentPane.add(num4);

            num5 = new JButton("5");
            num5.setBounds(487, 229, 89, 23);
            num5.setName("button5");
            num5.addActionListener(buttonL);
            contentPane.add(num5);

            questionArea = new JTextArea();
            questionArea.setBackground(Color.BLACK);
            questionArea.setForeground(Color.WHITE);
            questionArea.setLineWrap(true);
            questionArea.setFont(new Font("Myriad Web Pro Condensed", Font.PLAIN,
                    14));
            questionArea.setWrapStyleWord(true);
            questionArea.setText(LevelChanger.Question);
            questionArea.setRows(10);
            questionArea.setColumns(5);
            questionArea.setBounds(68, 21, 461, 159);
            contentPane.add(questionArea);

            hintArea = new JTextArea();
            hintArea.setForeground(Color.WHITE);
            hintArea.setBackground(Color.BLACK);
            hintArea.setText("Hint : " + LevelChanger.Hint);
            hintArea.setBounds(95, 278, 397, 58);
            contentPane.add(hintArea);

            Maxbutclick = new JLabel("Max Button count for level : "
                    + LevelChanger.buttonlimit);
            Maxbutclick
                    .setFont(new Font("Stencil Std", Font.BOLD | Font.ITALIC, 11));
            Maxbutclick.setBackground(Color.BLACK);
            Maxbutclick.setForeground(Color.WHITE);
            Maxbutclick.setBounds(321, 263, 255, 14);
            contentPane.add(Maxbutclick);

        }

        public void update() {
            livesleft.setText("Lives Left : " + LevelChanger.lives);
            livesleft.repaint();
        }

    }


    // ===== //


    import java.awt.EventQueue;

    public class LevelChanger {

        private static int buttoncount = 0;
        private static CodeGui frame = null;

        protected static int buttonlimit = 20;
        protected static int answer = 12;
        protected static int level = 1;
        protected static int lives = 10;
        protected static String Hint = "";
        protected static String Question = "default text";

        public static void main(String[] args) {

            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        CodeGui frame = new CodeGui();
                        LevelChanger.frame = frame;
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });
            checkbuttonlimitAndAnswer();

        }

        protected static void checkbuttonlimitAndAnswer() {
            System.out.println("1) buttoncount = " + buttoncount + " // lives = " + lives  + " // buttonlimit = " + buttonlimit);

            if (buttoncount > buttonlimit) {
                lives--;
                buttoncount = 0;
            }

            System.out.println("2) buttoncount = " + buttoncount + " // lives = " + lives  + " // buttonlimit = " + buttonlimit);

            if (frame != null) {
                frame.update();
            }

        }

        protected static void incButtonCount(int val) {
            buttoncount += val;
            checkbuttonlimitAndAnswer();
        }

    }


    // ===== //