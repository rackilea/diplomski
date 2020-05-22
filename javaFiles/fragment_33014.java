button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        generateReport(checkbox1.isSelected(),
                       checkbox2.isSelected(),
                       checkbox3.isSelected(),
                       checkbox4.isSelected(),
                       checkbox5.isSelected());
    }
});