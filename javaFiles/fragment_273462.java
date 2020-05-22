public BoxLayoutDemo() {
        JPanel pane = new JPanel();

        Box box = Box.createVerticalBox();
        box.add(new JButton("Button 1"));
        box.add(Box.createVerticalStrut(20));
        box.add(new JButton("Button 2"));
        box.add(Box.createVerticalStrut(20));
        box.add(new JButton("Button 3"));
        box.add(Box.createVerticalStrut(20));
        box.add(new JButton("Button 4"));
        box.add(Box.createVerticalStrut(20));
        box.add(new JButton("Button 5"));
        box.add(Box.createVerticalStrut(20));

        pane.add(box);

        JPanel pane2 = new JPanel(new FlowLayout(FlowLayout.LEADING));
        pane2.add(new JButton("ButtonButton"));

        JPanel panel = new JPanel(new BorderLayout()){
            public Dimension getPreferredSize() {
                return new Dimension(400, 260);
            }
        };
        panel.add(pane, BorderLayout.CENTER);
        panel.add(pane2, BorderLayout.SOUTH);

        JFrame frame = new JFrame("Slitting using different layouts");
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }