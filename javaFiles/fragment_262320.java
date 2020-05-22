public int spinValue = 0;
//...
Timer timer = new Timer(5, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        spinValue += 0.01;
        repaint();
    }
});