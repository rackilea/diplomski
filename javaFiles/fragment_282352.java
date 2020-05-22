DefaultTableModel tableModel = new DefaultTableModel(0,numCols) {
        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return Float.class;
        }
    };