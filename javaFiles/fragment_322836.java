JFrame frame = new JFrame();

    JPanel board = new JPanel();

    board.setLayout(null);
    board.setBounds(0, 0, 500, 500);

    for (int i = 0, x = 0; i < 10; i++, x += 50) {
        for (int j = 0, y = 0; j < 10; j++, y += 50) {
            JLabel lab = new JLabel("" + j);
            lab.setOpaque(true);
            lab.setBackground(Color.BLACK);
            lab.setBounds(x, y, 50, 50);
            board.add(lab);
        }
    }

    JLabel ladder = new JLabel();
    ladder.setBackground(Color.RED);
    ladder.setBounds(0, 0, 50, 200);
    ladder.setOpaque(true);

    JLayeredPane pane = frame.getLayeredPane();

    pane.add(ladder, new Integer(2)); // front
    pane.add(board, new Integer(1));  // back

    frame.setVisible(true);