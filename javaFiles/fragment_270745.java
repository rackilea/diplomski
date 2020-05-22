private void addListenerToSorter(RowSorter rowSorter, 
                           final JTable table, 
                           final JLabel rowCountLabel) {

    rowSorter.addRowSorterListener(new RowSorterListener() {
        @Override
        public void sorterChanged(RowSorterEvent e) {
            int newRowCount = table.getRowCount();
            rowCountLabel.setText("Number of view rows: " + newRowCount);
        }
    });
}