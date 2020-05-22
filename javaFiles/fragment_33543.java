JPanel left = new JPanel(new GridLayout(0, 2));
JPanel isle = new JPanel();
JPanel right = new JPanel(new GridLayout(0, 2));

for (int row = 0; row < 10; row++) {
    for (int col = 0; col < 4; col++) {
        JButton btn = new JButton("Row " + row + " seat " + col);
        if (col < 2) {
            left.add(btn);
        } else {
            right.add(btn);
        }
    }
}

setLayout(new GridLayout(1, 3));

add(left);
add(isle);
add(right);