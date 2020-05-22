import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class GameBoard extends javax.swing.JFrame {

    private JLabel Board;
    private JLabel playerNumber;
    private ButtonGroup group;
    private JButton startButton;
    private JRadioButton fourPlayer;
    private JRadioButton threePlayer;
    private JRadioButton twoPlayer;

    private Grid grid;

    /**
     * Auto-generated main method to display this JFrame
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Grid grid = new Grid();
                GameBoard inst = new GameBoard(grid);
                inst.setLocationRelativeTo(null);
                inst.setVisible(true);
            }
        });
    }

    public GameBoard(Grid grid) {
        super();
        this.grid = grid;
        initGUI();
    }

    private void initGUI() {
        try {
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setLayout(null);
            {
                Board = new JLabel();
                getContentPane().add(Board);
                Board.setText("jLabel1");
                Board.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/board.jpg")));
                Board.setBounds(199, 0, 742, 484);
            }
            {
                playerNumber = new JLabel();
                getContentPane().add(playerNumber);
                playerNumber.setText("Number of Players");
                playerNumber.setBounds(40, 22, 117, 27);
            }
            {
                twoPlayer = new JRadioButton();
                getContentPane().add(twoPlayer);
                twoPlayer.setText("Two Player");
                twoPlayer.setBounds(40, 55, 93, 20);
            }
            {
                threePlayer = new JRadioButton();
                getContentPane().add(threePlayer);
                threePlayer.setText("Three Players");
                threePlayer.setBounds(40, 76, 88, 20);
            }
            {
                fourPlayer = new JRadioButton();
                getContentPane().add(fourPlayer);
                fourPlayer.setText("Four Players");
                fourPlayer.setBounds(40, 99, 82, 20);
            }
            {
                startButton = new JButton();
                getContentPane().add(startButton);
                startButton.setText("Start Game");
                startButton.setBounds(43, 136, 83, 23);
            }

            {
                //Group the radio buttons.
                ButtonGroup group = new ButtonGroup();
                group.add(twoPlayer);
                group.add(threePlayer);
                group.add(fourPlayer);
            }

            pack();
            this.setSize(963, 523);
        } catch (Exception e) {
            //add your error handling code here
            e.printStackTrace();
        }

    }

}