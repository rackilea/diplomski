panel.setLayout(null);

    panel.add(desk);
    panel.add(ball);

    panel.setComponentZOrder(ball,0);
    panel.setComponentZOrder(desk,1);

    setContentPane(panel);

    desk.setBounds(0,0,800,600);
    ball.setBounds(375,232,25,25);