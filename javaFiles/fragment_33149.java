Icon brick = new ImageIcon(BoardOption.class.getResource("/images.jpg"));
JPanel wall = new JPanel(new GridLayout(8, 8, 0, 0));
JLabel bricks[][] = new JLabel[8][8];

for (int x = 0; x < 8; x++) {
    for (int y = 0; y < 8; y++) {
        bricks[y][x] = new JLabel(brick);
        wall.add(bricks[y][x]);
    }
}

JOptionPane.showMessageDialog(null, wall, "Another brick in the wall", JOptionPane.PLAIN_MESSAGE, null);