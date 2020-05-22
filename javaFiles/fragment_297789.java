JTable table = new JTable(new JTableModel()); 
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true); 

        TableCellRenderer buttonRenderer = new JTableButtonRenderer();
        table.getColumn("Button1").setCellRenderer(buttonRenderer);
        table.getColumn("Button2").setCellRenderer(buttonRenderer);