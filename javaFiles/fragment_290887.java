TableColumn dateColumn = jTable1.getColumnModel().getColumn(4);
dateColumn.setCellEditor(new TimeTableEditor());
TableColumn dateColumn1 = jTable1.getColumnModel().getColumn(5);
dateColumn1.setCellEditor(new TimeTableEditor());
TableColumn dateColumn3 = jTable1.getColumnModel().getColumn(0);
dateColumn3.setCellEditor(new DateTableEditor());