if (numbers[rowIdx][i] == 0) {
    JButton b = new JButton(" ");
    panel.add(b);
    b.addActionListener(createActionListener(rowIdx, i));
}

...

private ActionListener createActionListener(
    final int row, final int column) {
    ActionListener actionListener = new ActionListener() {
    {
        @Override
        public void actionPerformed(ActionEvent) {
            System.out.println("Pressed button in row "+row+", column "+column);
        }
    };
    return actionListener;
}