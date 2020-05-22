for (int i = 0; i < suggestedAcTableModel.getRowCount(); i++) {
    for(int j = 0; j < suggestedAcTableModel.getColumnCount(); j++){
        String acNameStr = suggestedAcTableModel.getValueAt(i, j).toString();
        if (acNameStr.equals(acName)) { 
           suggestedAcTableModel.removeRow(i);
           j = suggestedAcTableModel.getColumnCount();
           i--;
        }
    }
}