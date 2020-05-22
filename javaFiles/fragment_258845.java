public class Grid {
    private JFrame f;
    public Grid(String fname, int row, int column, int d) {
        f = new JFrame(fname);
        f.setLayout(new GridLayout(row,column));
        f.setSize(row*d,column*d);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addContent(row,column,d);
    }
    public void open() {
        f.setVisible(true);
    }
    private void addContent(int r, int c, int d) {
        Border border = BorderFactory.createLineBorder(Color.black, 2);
        for (int i = 0 ; i < r ; i++) {
            for (int j = 0 ; j < c ; j++) {
                f.add(new TicTacToeCell(border, d, d));
            }
        }
    }
    public static void main(String[] args) {
         Grid grid = new Grid("Test", 3, 3, 50);
         grid.open();
    }
    public static int clickValue = 0;
    public static String getClickedValue() {
        clickValue = clickValue == 0 ? 1 : 0;
        return clickValue == 0 ? "X" : "O";
    }
    public class TicTacToeCell extends JLabel {
        private static final long serialVersionUID = 1L;
        public TicTacToeCell(Border border, int height, int width) {
            setText("");
            setBorder(border);
            setPreferredSize(new Dimension(height, width));
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (getText().isEmpty()) {
                        setText(getClickedValue());
                    }
                }
            });
        }
    }
}