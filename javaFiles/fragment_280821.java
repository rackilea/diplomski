Object[][] data = new Object[5][3];

data[0][0] = "word";
data[1][0] = "jive";
data[2][0] = "stuff";
data[3][0] = "word2";
data[4][0] = "abc";

data[0][1] = new Integer(410);
data[1][1] = new Integer(45);
data[2][1] = new Integer(456456);
data[3][1] = new Integer(4);
data[4][1] = new Integer(4);

String[] columnNames = new String[] {"testcolumn1", "testcolumn2"};

DefaultTableModel tm2 = new DefaultTableModel(data, columnNames) {

    @Override
    public Class<?> getColumnClass(int col) {

        Class retVal = Object.class;

        if(getRowCount() > 0)
            retVal =  getValueAt(0, col).getClass();

        return retVal;
    }

};