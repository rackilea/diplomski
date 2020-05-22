public class EightQueensUI extends JFrame {

    // gui components
    Icon queenIcon;
    JLabel imageLabel;
    EightQueensSolver solver;

    // constructor method
    public EightQueensUI(int boardSize) {
        super("8 Queens: Freddie Style");
        setPreferredSize(new Dimension(800, 800));
        getContentPane().setLayout(new GridLayout(boardSize, boardSize));
        queenIcon = new ImageIcon(getClass().getResource("circle.png"));
        solver = new EightQueensSolver(boardSize);

        solver.solve();

        for(int row=0;row<boardSize;row++){
            for(int col=0;col<boardSize;col++){
                JPanel panel = new JPanel(new BorderLayout());
                panel.setBackground( (col-row)%2 == 0 ? Color.BLACK : Color.WHITE);
                if(solver.getQueenColumnPosition(row)==col){
                    panel.add(new JLabel(queenIcon));
                }
                getContentPane().add(panel);
            }
        }

    } // end constructor

} // end class EightQueensUI