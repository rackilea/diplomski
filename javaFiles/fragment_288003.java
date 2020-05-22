ListSelectionModel lsm = table.getSelectionModel();
int start = lsm.getAnchorSelectionIndex();
int end = lsm.getLeadSelectionIndex();
System.out.println(start + " : " + end);
TableColumnModel tcm = table.getColumnModel();
lsm = tcm.getSelectionModel();
start = lsm.getAnchorSelectionIndex();
end = lsm.getLeadSelectionIndex();
System.out.println(start + " : " + end);