JButton newPersonButton = new JButton("New Person");
newPersonButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
        Data data = NewPerson.createPerson(frame);
        if (data != null) {
            JLabel lblHomer = new JLabel(data.names);
            panel_1.add(lblHomer, "cell 7 5");
            panel_1.revalidate();
        }
    }
});