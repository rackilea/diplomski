SwingUtilities.invokeLater(new Runnable() {
    public void run() {
        frame.remove(l);
        frame.validate();
        frame.repaint();
    }
});