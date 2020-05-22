myObject.setProgress(progress);
          if (table.isEditing()) {
            if (table.getEditingRow() == myObject.getRow()) {
              table.getCellEditor().stopCellEditing();
            }
          }
          model.fireTableRowsUpdated(row, row);