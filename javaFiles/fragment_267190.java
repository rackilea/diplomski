int[] indices = new int[yourModel.getRowCount() -1];
for (int i = 0; i < indices.length; i++) {
  indices[i] = i+1;
}

sorter.setRowFilter(RowFilter.regexFilter(selectedItem, indices));