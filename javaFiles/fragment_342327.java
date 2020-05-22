final JTable table = new JTable(new DefaultTableModel(new Object[]{"Title", "Artist", "Album", "Time"}, 0) {

        @Override
        public void addRow(Object[] rowData) {
            Vector blah = DefaultTableModel.convertToVector(rowData);
            insertRow(super.getRowCount(), blah);
        }

        @Override
        public void insertRow(int row, Vector data) {
            super.dataVector.insertElementAt(data, row);
            super.fireTableRowsInserted(row, row);
        }
    });