public static class MainPanel extends JPanel{
    public MainPanel() {
        this.setLayout(null);
        JLabel A_label = new JLabel("B");

        A_label.setBounds(100, 100, 10, 10);//set location & size
        //Or
        //A_label.setSize(10, 10);
        //A_label.setLocation(100, 100);

        A_label.setForeground(Color.red);
        this.add(A_label);
    }
}