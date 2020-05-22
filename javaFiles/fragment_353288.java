import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;


public class ScratchPaper extends JFrame {
    private static final long serialVersionUID = 1L;
    private static final int GRIDSIZE = 8;
    private JPanel[][] whitePanel = new WhitePanel[GRIDSIZE][GRIDSIZE];
    private JPanel[][] blackPanel = new BlackPanel[GRIDSIZE][GRIDSIZE];
    private Random rand = new Random();
    JButton b1 = new JButton("Btn1");
    JButton b2 = new JButton("Btn2");
    JButton b3 = new JButton("Btn3"); 
    JLabel l1 = new JLabel("Lbl1");
    JLabel l2 = new JLabel("Lbl2");
    JLabel l3 = new JLabel("Lbl3");
    JPanel panel = new JPanel();

    private JComponent[][] randObjects = {{b1, b2, b3}, {l1, l2, l3}, {panel, panel, panel}};
    private Color[] randColors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA};


    public ScratchPaper() {
        initGUI();
        setTitle("EXAMPLE");
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initGUI() {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(GRIDSIZE, GRIDSIZE)); // makes 8*8 grid
        add(centerPanel, BorderLayout.CENTER);

        MouseAdapter ma = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Component clickedComp = findComponentAt(e.getPoint());
                JPanel target = (JPanel) clickedComp;
                panel.setBackground(randColors[rand.nextInt(randColors.length)]);

                if (target instanceof WhitePanel){
                    target.add(randObjects[rand.nextInt(randObjects.length)][rand.nextInt(randObjects[0].length)]); 
                    target.updateUI();
                }
            }
        };
        addMouseListener(ma);

         for (int row=0; row<GRIDSIZE; row++) {
            for (int col=0; col<GRIDSIZE; col++) {
                whitePanel[row][col] = new WhitePanel(row, col);
                blackPanel[row][col] = new BlackPanel(row, col);

                if ((row%2 == 0 && col%2 == 0) || ((row+1)%2 == 0 && (col+1)%2 == 0)) {
                    centerPanel.add(whitePanel[row][col]);
                } 
                else {
                    centerPanel.add(blackPanel[row][col]);
                }
            }
         }
    }


    public static void main(String args[]) {
        try {
            String className = UIManager.getCrossPlatformLookAndFeelClassName();
            UIManager.setLookAndFeel(className);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                new ScratchPaper();
            }
        });
    }

    class WhitePanel extends JPanel {   
        private static final int SIZE = 50;

        public WhitePanel(int row, int col) {
            Dimension size = new Dimension(SIZE, SIZE);
            setPreferredSize(size);
            setBackground(Color.WHITE);
        }
    }

    class BlackPanel extends JPanel {
        private static final int SIZE = 50;

        public BlackPanel(int row, int col) {
            Dimension size = new Dimension(SIZE, SIZE);
            setPreferredSize(size);
            setBackground(Color.BLACK);
        }
    }
}