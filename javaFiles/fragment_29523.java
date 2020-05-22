final JTable table = new JTable(new AbstractTableModel() {

        @Override
        public Object getValueAt(int r, int c) {
            return data[r][c];
        }

        @Override
        public int getRowCount() {
            return data.length;
        }

        @Override
        public int getColumnCount() {
            return data[1].length;
        }

    });

    table.setRowSelectionAllowed(true);
    table.setColumnSelectionAllowed(true);
    table.setCellSelectionEnabled(true);