JButton saveButton = new JButton("Save");
saveButton.addActionListener(new ActionListener() {
{
    @Override
    public void actionPerformed(ActionEvent) {
        saveButtonWasPressed();
    }
});