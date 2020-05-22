addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent e) {

                int row = e.getFirstRow();
                int col = e.getColumn();
                TableModel tableModel = (TableModel) e.getSource();
                Object data = null;

                try {
                    if (row >= 0 && col >= 0) {
                        data = tableModel.getValueAt(row, col);

                        boolean ishotKeyColEmpty = false;
                        boolean ishTypeColEmpty = false;
                        if (tableModel.getValueAt(row, 0) != null) {
                            ishotKeyColEmpty = tableModel.getValueAt(row, 0).toString().isEmpty();
                        }
                        if (tableModel.getValueAt(row, 2) != null) {
                            ishTypeColEmpty = tableModel.getValueAt(row, 2).toString().isEmpty();
                        }

                        if (data != null && data.toString().equals("") && !ishotKeyColEmpty && !ishTypeColEmpty) {
                            tableModel.setValueAt("", row, 0);
                            tableModel.setValueAt("", row, 2);
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }

        }