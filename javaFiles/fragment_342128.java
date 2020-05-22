table.clearSelection();

ListSelectionModel selectionModel = table.getSelectionModel();
selectionModel.setAnchorSelectionIndex(-1);
selectionModel.setLeadSelectionIndex(-1);

TableColumnModel columnModel = table.getColumnModel();
columnModel.getSelectionModel().setAnchorSelectionIndex(-1);
columnModel.getSelectionModel().setLeadSelectionIndex(-1);