final int x = 13;

JButton btn = new JButton("New Button");
    btn.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        System.out.println(x);
    }
});