private void newFilter(int numberOfRows)
{
    final RowFilter<TableModel, Integer> filter = new RowFilter<TableModel, Integer>()
    {
        @Override
        public boolean include(RowFilter.Entry<? extends TableModel, ? extends Integer> entry)
        {
            int i = table.convertRowIndexToView(entry.getIdentifier());

            //System.out.println(i + " : " + numberOfRows + " : " + entry.getIdentifier());

            return i < numberOfRows;
        }

    };

    ((TableRowSorter) table.getRowSorter()).setRowFilter(null);

    SwingUtilities.invokeLater(new Runnable()
    {
        public void run()
        {
            ((TableRowSorter) table.getRowSorter()).setRowFilter(filter);
        }
    });

}