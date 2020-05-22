EventQueue.invokeLater(new Runnable() {
    @Override
    public void run() {
        buttons[0].setIcon(new ImageIcon("path/to/new/icon"));
    }
}