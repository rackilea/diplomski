int[] selectedIndexs = jtable.getSelectedRows();
jtable.selectAll();

for (int i = 0; i < jtable.getRowCount(); i++) {
    for (int selectedIndex : selectedIndexs) {
        if (selectedIndex == i) {
            jtable.removeRowSelectionInterval(i, i);
            break;
        }
    }
}