public static void main(String[] args)
{
    // these three arrays represent the test data otherwise read
    //  from a file
    int[] ia = { 1493, -832722, 0, 1, 162 };
    double[] da = { 0.4, -6.382, 9.0E-21 };
    String[] sa = { "The", "fox", "jumped", "over", "the", "dog!"};


    Object[] columnNames = { "Int", "Real", "Tokens" };


    DefaultTableModel dm = new DefaultTableModel(columnNames, 0);
    JTable tbl = new JTable(dm);

    // while reading for a file, would know the max length in
    // a different way
    int loopCtr = Math.max(ia.length, da.length);
    loopCtr = Math.max(loopCtr, sa.length);

    // loop for the longest entry; for each entry decide if there
    // is a value
    for (int i = 0; i < loopCtr; ++i) {
        Integer iv = (i < ia.length ? ia[i] : null);
        Double dv = (i < da.length ? da[i] : null);
        String sv = (i < sa.length ? sa[i] : "");

        //add the row; if no value for a given entry, use an empty
        // String
        dm.addRow(new Object[]{(iv != null ? iv : ""),
                (dv != null ? dv : ""),
                sv});
    }

    //just output for the moment
    int cols = dm.getColumnCount();
    int rows = dm.getRowCount();
    StringBuilder sb = new StringBuilder();
    for (int row = 0; row < rows; ++row) {
        sb.setLength(0);
        for (int col = 0; col < cols; ++col) {
            sb.append(dm.getValueAt(row, col));
            sb.append("\t");                
        }

        System.out.println(sb.toString());
    }
}