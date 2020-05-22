class SubmitResponder implements ActionListener {

    private final RegisterPanel rp;

    public SubmitResponder(RegisterPanel rp) {
        this.rp = rp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        rp.text.setText("Submit Complete");
    }
}