@Override
public void actionPerformed(ActionEvent e) {
    for (int i = 0; i < data.size(); i++) {
        if (data.get(i).isSelected()) {
            ((MyTableTestModel) table.getModel()).removeRow(i);
        }
    }
}