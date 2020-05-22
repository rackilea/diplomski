class MatrixButton {
    private int column;
    private int row;
    private JButton button = new JButton();
    private int value;

    public MatrixButton(int column, int row, int value) {
        this.column = column;
        this.row = row;
        setValue(value);
    }

    public void addActionListener(ActionListener listener) {
        button.addActionListener(listener);
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public JButton getButton() {
        return button;
    }

    public int getValue() {
        return value;
    }

    public final void setValue(int value) {
        this.value = value;
        button.setText("" + value);
    }
}