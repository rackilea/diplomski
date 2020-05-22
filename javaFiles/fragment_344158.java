//instance table model
    DefaultTableModel tableModel = new DefaultTableModel(new Object[][]{},
            new String[]{
                "ID Gejala", "Nama Gejala"
            }) {

        @Override
        public boolean isCellEditable(int row, int column) {
            //all cells false
            return false;
        }
    };

    TabelGejala.setModel(tableModel);