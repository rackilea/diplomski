String[] colNames = new String[data[1].length];
for(int i=0; i<colNames.length; i++)
    colNames[i] = "C" + i;

DefaultTableModel model = new DefaultTableModel(data,colNames){
    @Override
    public boolean isCellEditable(int row, int column){
        return false;
    }};