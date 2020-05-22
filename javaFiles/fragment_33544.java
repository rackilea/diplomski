setLayout(new GridLayout(0, 5));

for (int row = 0; row < 10; row++) {
    for (int col = 0; col < 4; col++) {
        JButton btn = new JButton("Row " + row + " seat " + col);
        if (col == 2) {
            add(new JPanel());
        }
        add(btn);
    }
}