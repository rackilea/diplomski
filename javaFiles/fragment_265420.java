@Override
public void actionPerformed(ActionEvent e) {
    for (int i = data.size()-1; i >= 0; --i) {
        if (data.get(i).isSelected()) {
            ((MyTableTestModel) table.getModel()).removeRow(i);
        }
    }
}