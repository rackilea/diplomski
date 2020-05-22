yourTable.setModel(
        new DefaultTableModel(data2, new String [] {"Column1Title", "Cloumn2Title"}) {
        Class[] types = new Class[] {String.class,String.class}; 
        boolean[] canEdit = new boolean[] {true, true};
        @Override
        public Class getColumnClass(int columnIndex){ return types [columnIndex];}
        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex){ return canEdit [columnIndex];}
});