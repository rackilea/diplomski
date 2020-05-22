Timer timer = new Timer(1000, new ActionListener(){
    public void actionPerformed(ActionEvent e) {
        button.setText(String.valueOf(count));
        count++;
    }
});
timer.start();