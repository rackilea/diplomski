@Override
public void chartMouseClicked(ChartMouseEvent event) {
    CategoryItemEntity entity = (CategoryItemEntity) event.getEntity();
    JPanel panel = new JPanel(new GridLayout(0, 1));
    Comparable row = entity.getRowKey();
    Comparable col = entity.getColumnKey();
    panel.add(new JLabel(String.valueOf(row)));
    panel.add(new JLabel(String.valueOf(col)));
    panel.add(new JLabel(String.valueOf(entity.getDataset().getValue(row, col))));
    JOptionPane.showMessageDialog(rootPane, panel);
}