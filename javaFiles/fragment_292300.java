class DisplayPane implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            final String[] newColumnNames = { "File", "Name", "Extension" };

            for (int i = 0; i < rowDataTable.length; i++){
                rowDataTable[i] =new String[] { "", "", "" }; // See below
            }
            fileTableModel = new CustomTableModel(rowDataTable, newColumnNames);

            fileTable.setModel(fileTableModel);
            fillTableActionListener.setModel(fileTableModel);
            fileTableModel.fireTableStructureChanged();
            fileTableModel.fireTableDataChanged();
        }
    }