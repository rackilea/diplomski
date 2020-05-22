import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MagicSquare extends JPanel {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new MagicSquare());
                frame.setSize(400, 400);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    JLabel sizeLabel = new JLabel("Enter A Square Size: ");
    JButton setSize;
    private JSpinner squareSize;
    JTextField field;

    public MagicSquare() {
        setLayout(new BorderLayout());
        JPanel subPanel = new JPanel();

        subPanel.add(sizeLabel);

        squareSize = new JSpinner();
        subPanel.add(squareSize);

        setSize = new JButton("Enter");
        subPanel.add(setSize);
        DrawFieldsListener dfl = new DrawFieldsListener();
        setSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int gridSize = (int) squareSize.getValue();
                dfl.makeGrid(gridSize);
            }
        });

        add(subPanel, BorderLayout.NORTH);
        add(dfl, BorderLayout.CENTER);
    }

    class DrawFieldsListener extends JPanel {

        private JButton calculate;
        private JButton reset;

        private ArrayList<JTextField> inputFields = new ArrayList<JTextField>();
        private ArrayList<Integer> inputs = new ArrayList<Integer>();
        private ArrayList<Integer> totals = new ArrayList<Integer>();

        private int squared = 0;
        private int square = 0;

        private JPanel centerPanel = new JPanel();
        private JPanel bottomPanel = new JPanel();

        public void makeGrid(int gridSize) {
            square = gridSize;
            squared = square * square;

            centerPanel.setLayout(new GridLayout(square, square));

            for (int i = 0; i < squared; i++) {
                field = new JTextField();
                field.setColumns(3);
                inputFields.add(field);
                centerPanel.add(inputFields.get(i));
                System.out.println("DRAWING");
            }

            add(centerPanel, BorderLayout.CENTER);
            System.out.println("ADDING ADDITINOAL BUTTONS");
            additionalButtons();
            System.out.println("ADDED ADDITINOAL BUTTONS");
            System.out.println("REPAINTING");
            revalidate();
            repaint();
            System.out.println("REPAINTED");
        }

        public void additionalButtons() {
            calculate = new JButton("Calculate");
            reset = new JButton("Reset");

            bottomPanel.setLayout(new GridLayout(2, 2));
            bottomPanel.add(reset);
            bottomPanel.add(calculate);

            add(bottomPanel, BorderLayout.SOUTH);

//          calculate.addActionListener(new CalculateListener());
//          reset.addActionListener(new ResetListener());
        }
    }
}