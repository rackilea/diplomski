comboProv.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedProv = (String)comboProv.getSelectedItem();
        System.out.print(selectedProv);
    }
});