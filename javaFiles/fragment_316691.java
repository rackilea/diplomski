static void test3() {
    JFrame f = new JFrame("Test");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(800, 360);
    Container pane = f.getContentPane();
    pane.setLayout(new GridBagLayout());

    String[] a = {
            "Lorem ipsum dolor sit amet",
            "consectetur adipisicing",
            "elit,",
            "sed do",
            "eiusmod",
    };
    for (int i = 0; i < 5; i++) {
        JButton test=new JButton(a[i]);
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = i %3;
        c.gridy = i /3;
        c.fill = GridBagConstraints.HORIZONTAL;
        test.setPreferredSize(new Dimension(250,25));
        f.add(test, c);
    }
    f.setVisible(true);
}