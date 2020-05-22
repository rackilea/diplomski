public class CorrectlySizedTable extends JTable
{
    public void adjustColumns()
    {
        TableColumnModel tcm = getColumnModel();

        for (int i = 0; i < tcm.getColumnCount(); i++)
        {
            adjustColumn(i);
        }
    }

    public void adjustColumn(final int column)
    {
        TableColumn tableColumn = getColumnModel().getColumn(column);

        if (! tableColumn.getResizable()) return;

        int columnHeaderWidth = getColumnHeaderWidth( column );
        int columnDataWidth   = getColumnDataWidth( column );
        int preferredWidth  = Math.max(columnHeaderWidth, columnDataWidth);

        updateTableColumn(column, preferredWidth);
    }

    /*
     *  Calculated the width based on the column name
     */
    private int getColumnHeaderWidth(int column)
    {

        TableColumn tableColumn = getColumnModel().getColumn(column);
        Object value = tableColumn.getHeaderValue();
        TableCellRenderer renderer = tableColumn.getHeaderRenderer();

        if (renderer == null)
        {
            renderer = getTableHeader().getDefaultRenderer();
        }

        Component c = renderer.getTableCellRendererComponent(this, value, false, false, -1, column);
        return c.getPreferredSize().width;
    }

    /*
     *  Calculate the width based on the widest cell renderer for the
     *  given column.
     */
    private int getColumnDataWidth(int column)
    {

        int preferredWidth = 0;
        int maxWidth = getColumnModel().getColumn(column).getMaxWidth();

        for (int row = 0; row < getRowCount(); row++)
        {
            preferredWidth = Math.max(preferredWidth, getCellDataWidth(row, column));

            //  We've exceeded the maximum width, no need to check other rows

            if (preferredWidth >= maxWidth)
                break;
        }

        return preferredWidth;
    }

    /*
     *  Get the preferred width for the specified cell
     */
    private int getCellDataWidth(int row, int column)
    {
        //  Inovke the renderer for the cell to calculate the preferred width

        TableCellRenderer cellRenderer = getCellRenderer(row, column);
        Component c = prepareRenderer(cellRenderer, row, column);
        int width = c.getPreferredSize().width + getIntercellSpacing().width;

        return width;
    }

    private void updateTableColumn(int column, int width)
    {
        final TableColumn tableColumn = getColumnModel().getColumn(column);
        MainWindow.logger.severe("ColumnWidth:"+width);
        tableColumn.setPreferredWidth(width);
        if(column==0 || getColumnClass(column)==Boolean.class)
        {
            tableColumn.setMaxWidth(width);
        }
    }

    public void setModel(TableModel dataModel) {
        super.setModel(dataModel);
        adjustColumns();
    }
}