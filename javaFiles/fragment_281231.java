private class StatusUpdateListener implements ActionListener {
    private JTextField input;
    private JLabel status;

    public SubmitButtonListener(JTextField source, JLabel dest) {
       input = source;
       status = dest;
    }

    public void actionPerformed(ActionEvent e){
        String text = input.getText();
        status.setText(text);
    }
}