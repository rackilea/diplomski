Timer timer = new Timer(1000, new ActionListener() {
    private int count;
    @Override
    public void actionPerformed(ActionEvent evt) {
        nextGen();
        panel.repaint();
        count++;
        if (count >= 5) {
            ((Timer)evt.getSource()).stop();
        }
    }
});
timer.start();