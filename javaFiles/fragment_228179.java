JPanel pnl = new JPanel();
    GroupLayout l = new GroupLayout(pnl);
    pnl.setLayout(l);

    JButton b1 = new JButton("1");
    JButton b2 = new JButton("2");
    JButton b3 = new JButton("3");

    l.setHorizontalGroup(
            l.createSequentialGroup()
                .addComponent(b1)
                .addGroup(l.createParallelGroup()
                    .addComponent(b2)
                    .addComponent(b3)));

    l.setVerticalGroup(
            l.createParallelGroup()
                .addComponent(b1)
                .addGroup(l.createSequentialGroup()
                    .addComponent(b2)
                    .addComponent(b3)));

    JFrame f = new JFrame("test");
    f.setContentPane(pnl);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(1024, 768);
    f.setVisible(true);