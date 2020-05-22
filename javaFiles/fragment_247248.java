final Image mine = ImageIO.read(new File("resources/mine.png"));
final boolean[][] showMine = new boolean[9][9];
Random random = new Random();
JPanel panel = new JPanel(new GridLayout(9, 9));
for (int i = 0; i < 9; i++) {
    for (int j = 0; j < 9; j++) {

        showMine[i][j] = random.nextBoolean();

        final int x = i;
        final int y = j;
        final JButton button = new JButton();
        button.setText(String.valueOf(i * 9 + j));
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                button.setEnabled(false);
                button.setText("");
                if (showMine[x][y]) {
                    button.setDisabledIcon(new ImageIcon(mine));
                }
            }
        });

        panel.add(button);
    }
}
add(panel);