Timer timer = new Timer(duration, new ActionListener(){
    public void actionPerformed(ActionEvent e){
        setVisible(false);
    }
});
timer.setRepeats(false);
timer.start();