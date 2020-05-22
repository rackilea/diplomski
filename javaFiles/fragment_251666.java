public Column(int pos, boolean init, int lastX) {

    this.position = pos;


    setLayout(null);
    setBackground(Color.WHITE);

    floor = new JPanel();
    floor.setLayout(null);
    floor.setBackground(Color.BLACK);

    if (init) {

        setBounds((WIDTH * position) - WIDTH, 0, WIDTH, HEIGHT);
        floor.setBounds(0, HEIGHT - FLOOR_H, WIDTH, FLOOR_H);

    } else {

        setBounds(lastX + WIDTH, 0, WIDTH, HEIGHT);
        floor.setBounds(0,
                (HEIGHT - (FLOOR_H + (FLOOR_H * rand.nextInt(2) / 2))),
                WIDTH, FLOOR_H * 2);
    }