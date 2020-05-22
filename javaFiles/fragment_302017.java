class doneActionListener implements ActionListener{

    private JFrame toBeClose;

    public doneActionListener(JFrame toBeClose) {
        this.toBeClose = toBeClose;
    }

    public void actionPerformed(ActionEvent e) {
        toBeClose.setVisible(false);
        toBeClose.dispose();
    }
}