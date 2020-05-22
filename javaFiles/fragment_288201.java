JTable table = new JTable();

DateCellRenderer renderer = new DateCellRenderer();
// Apply for a single column
table.getColumnModel().getColumn(0).setCellRenderer(renderer);
// OR apply for all columns using the Date class
table.setDefaultRenderer(Date.class, renderer);