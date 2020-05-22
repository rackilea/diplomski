g.setColor(Color.RED);
        int scrollBottom = scroll.getInsets().bottom;
        int lowerBorderTop = height - scrollBottom;
        g.drawLine(x, height - scrollBottom - 1, width - 10,  height - scrollBottom - 1);
        g.drawRect(x + 1,  height - scrollBottom, width - 10, 10);
        Color oldColor = null;
        Component cellRendererComponent = null;
        int columnWidths = x ;//- scroll.getViewport().getViewRect().x;
        for (int column = 0; column < table.getColumnCount(); column++)
        {
            TableCellRenderer cellRenderer = table.getCellRenderer(0, column);
            cellRendererComponent = cellRenderer.getTableCellRendererComponent(table, 
                    getFooterValueAt(column), false, false, 0, column);
            if (oldColor == null)
            {
                oldColor = cellRendererComponent.getBackground();
            }
            int columnWidth = table.getColumnModel().getColumn(column).getWidth();
            cellRendererComponent.setForeground(Color.BLACK);
            cellRendererComponent.setBackground(COLORS[column % COLORS.length]);
            cellRendererPane.paintComponent(g, cellRendererComponent, scroll, columnWidths, 
                  lowerBorderTop , columnWidth, table.getRowHeight(), false);
            columnWidths += columnWidth;
        }
        if (cellRendererComponent != null)
        {
            cellRendererComponent.setBackground(oldColor);
        }