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