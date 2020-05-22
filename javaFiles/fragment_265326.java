final Timer timer = new Timer(500, null);
ActionListener listener = new ActionListsner() {
    private Iterator<Word> it = words.iterator();
    @Override 
    public void actionPerformed(ActionEvent e) {
        if (it.hasNext()) {
            label.setText(it.next().getName());
        }
        else {
            timer.stop();
        }
    }
};
timer.addActionListener(listener);
timer.start();