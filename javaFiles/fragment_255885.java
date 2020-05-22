@Override
public void actionPerformed(ActionEvent e) {
    int[] lines = table.getSelectedRows();
    for (int i = 0; i < lines.length; i++) {
        lines[i] = table.convertRowIndexToModel(lines[i]);
    }
    List<Integer> l = new ArrayList<Integer>();
    for (int i : lines) {
        l.add(i);
    }
    for (int i = table.getRowCount() - 1; i >= 0; i--) {
        if (!l.contains(i)) {
            model.removeRow(i);
        }
    }
}