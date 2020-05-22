JButton btn = new JButton("Start");
btn.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
    }
});