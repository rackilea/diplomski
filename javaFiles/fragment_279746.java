int cnt = 0;
for (int row = 0; row < 3; ++row) {
    for (int col = 0; col < 3; ++col) {
        JPanel box = new JPanel(new GridLayout(3, 3));
        box.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        for (int cell = 0; cell < 9; ++cell) {
            txtfields[cnt] = new JTextField(2);
            box.add(txtfields[cnt++]);
        }
        board.add(box);
    }
}