DefaultTableModel model = new DefaultTableModel(1, 3) {

        /** 
         * @inherited <p>
         */
        @Override
        public void setValueAt(Object aValue, int row, int column) {
            super.setValueAt(aValue, row, column);
            if (shouldAddRow(row, column)) {
                addRow(new Object[] {});
            }
        }

        private boolean shouldAddRow(int lastEditedRow, int lastEditedColumn) {
            // implement your logic here
            return lastEditedRow == getRowCount() -1;
        }


    };