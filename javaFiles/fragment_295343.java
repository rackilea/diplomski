Timer timer = new Timer(25, new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
        mapP.repaint();
    }
});
timer.setRepeats(true);
timer.setCoalesce(true);
timer.start();