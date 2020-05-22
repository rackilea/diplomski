import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class GameWindow extends JFrame {

    private final JPanel playArea = new CustomPanel(710, 710);  
    private final JButton[][] boardSquares = new JButton[8][8];
    private final JPanel board;
    private final JPanel sidebar = new CustomPanel(100, 100);
    private final JLabel message = new JLabel("Game by ...");

    public  GameWindow() {
        playArea.setLayout(new BorderLayout(3,3));
        playArea.setBorder(new EmptyBorder(5, 5, 5, 5));

        JToolBar tools = new JToolBar();


        tools.setFloatable(false);
        playArea.add(tools, BorderLayout.PAGE_START);
        tools.add(new JButton("New Game"));
        tools.add(new JButton("Save"));
        tools.add(new JButton("Restore")); 
        tools.addSeparator();
        tools.add(new JButton("Resign"));
        tools.addSeparator();
        tools.add(message);

        board = new CustomPanel(600, 600);
        board.setLayout(new GridLayout(0, 8));
        board.setBorder(new LineBorder(Color.BLACK));
        playArea.add(board, BorderLayout.CENTER);
        playArea.add(sidebar, BorderLayout.LINE_START);

        Insets buttonMargin = new Insets(0,0,0,0);
        for (int i = 0; i < boardSquares.length; i++) {
           for (int j = 0; j < boardSquares[i].length; j++) {
                JButton square = new JButton();
                square.setOpaque(true);
                square.setMargin(buttonMargin);
                if ((i+j)%2 == 0) {
                    square.setBackground(Color.WHITE);
                } 
                else {
                    square.setBackground(Color.BLACK);
                }
                board.add(boardSquares[j][i] = square);
            }
        }
    }

    private class CustomPanel extends JPanel {
        private int width;
        private int height;

        public CustomPanel(int width, int height) {
            this.width = width;
            this.height = height;
            setOpaque(true);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(width, height);
        }
    }

    public final JComponent getChessBoard() {
    return board;
    }

    public final JComponent getGui() {
        return playArea;
    }

    public static void main(String[] args) {

        GameWindow window = new GameWindow();

        JFrame frame = new JFrame("Checkers");
        frame.setResizable(false);
        frame.setContentPane(window.getGui());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.pack();

        frame.setVisible(true);
    }
}