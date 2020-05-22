private static void addTables(){
   JTable tblMain = new JTable(Util_Tables.getModel());
}


//in the Util_Tables class, if the tables needs to be updated
private DefaultTableModel model;
public static DefaultTableModel getModel() {
    if (model == null) {
        model = new DefaultTableModel();
    }

}