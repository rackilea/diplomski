JButton button = new JButton("Press me");
int delay = 2000; //milliseconds
Timer timer = new Timer(delay, new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
        button.setEnabled(true);
        button.setText("");
    }
});
timer.setRepeats(false);
button.addActionListener(new ActionListener {
    public void actionPerformed(ActionEvent ae) {
        JButton button = ((JButton)e.getSource());
        button.setEnabled(false);
        button.setText("Wait a second")
        timer.start();
    }
}