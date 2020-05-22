Timer timer = new Timer(1000, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent evt) {
        //...
    }
});
timer.setRepeats(false); // So you are notified only once per mouseEnter event

jl.addMouseListener(new MouseAdapter() {
    public void mouseEntered(MouseEvent me) {
        timer.restart();
    }
});