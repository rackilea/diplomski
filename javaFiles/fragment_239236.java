JScrollPane scroll = new JScrollPane (area2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    b = new JButton("click Me");
    b.setBounds(100, 95, 80, 30);
    f1.add(b);

    area1.setBounds(10, 30, 200, 60);
    area2.setBounds(5, 5, 480, 480);
    f1.add(area1);
    f2.add(area2);