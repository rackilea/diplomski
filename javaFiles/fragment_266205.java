JButton save = new JButton("Save");
save.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(textField.getText());
        TableModel model = table.getModel();
        for (int r = 0; r < model.getRowCount(); r++) {
            for (int c = 0; c < model.getColumnCount(); c++) {
                System.out.print(model.getValueAt(r, c) + " ");
            }
            System.out.println();
        }
    }
});