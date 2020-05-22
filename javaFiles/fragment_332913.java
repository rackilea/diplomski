if(jtf.getText().equals(password)) {
    getContentPane().setBackground(Color.green);
    lbl.setText("Welcome");

} else {
    getContentPane().setBackground(Color.red);
    lbl.setText("Access Denied");
}

Timer timer = new Timer(3000, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        getContentPane().setBackground(Color.cyan);
        lbl.setText("Enter your password");
    }
});
timer.setRepeats(false);
timer.start();