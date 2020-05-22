@Override
        public Class<?> getColumnClass(int columnIndex) {
            Object value = this.getValueAt(0, columnIndex);
            return (value == null ? Object.class : value.getClass());
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public String getColumnName(int columnIndex) {
            return columnNames[columnIndex];
        }

        @Override
        public int getRowCount() {
            return data.length;
        }