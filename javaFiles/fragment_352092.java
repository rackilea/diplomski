//remove rows with instances of "5/13/2013"
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (((String)tableModel.getValueAt(i, 0)).equals("5/13/2013")) {
                tableModel.removeRow(i);
            }//end of if block
        }//end of for block