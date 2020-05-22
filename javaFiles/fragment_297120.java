class Knappelytter implements ActionListener {
    private JTextField field;

    public Knappelytter(JTextField field) {
        this.field = field;
    }

    public void actionPerformed(ActionEvent e) {
        String text = field.getText();
    }
}