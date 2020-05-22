public Etst() {
    JFrame f = new JFrame();
    f.setLayout(new BorderLayout());
    JTextArea area = new JTextArea();
    area.setLineWrap(true);
    f.add(area);
    f.setSize(100, 100);
    f.setVisible(true);
}