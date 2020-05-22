private class thehandler implements ActionListener {

    private Looper looper;

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == click) {
            if (looper == null) {
                looper = new Looper();
                Thread t = new Thread(looper);
                t.start();
            } else {
                looper.stop();
                looper = null;
            }
        }
    }
}