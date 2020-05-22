final Vector<DataObject> myDataObjects = new Vector<DataObject>();
myDataObjects.add(...);// add your objects
JTable table = new JTable(new AbstractTableModel() {

    public int getRowCount() {return myDataObjects.size();}
    public int getColumnCount() { return 3; }
    public Object getValueAt(int row, int column){
         switch (column) {
           case 0:
              return myDataObjects.get(row).getName();
           case 1:
              return myDataObjects.get(row).getGender();
           case 2:
              return myDataObjects.get(row).getAge();
           default:
              return "";
         }
    }
});