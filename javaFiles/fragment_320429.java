game = new JPanel();
    ImageIcon bbb = new ImageIcon("bbb.gif");
    ImageIcon bbbH = new ImageIcon("bbbH.gif");
    JLabel bbbl = new JLabel(bbb);

    game.setLayout(new GridLayout(2, 2));
    game.add(bbol);
    game.add(bbgl);
    game.add(bbgrl);
    game.add(bbbl);
    if (flashed == 1) {
        bbbl.setIcon(bbbH);
    } else {
        bbbl.setIcon(bbb);
    }