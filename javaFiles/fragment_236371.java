public void stateChanged(ChangeEvent e)
{
    Rectangle viewRect = viewport.getViewRect();
    int first = table.rowAtPoint(new Point(0, viewRect.y));
    if (first == -1)
    {
        return; // Table is empty
    }
    int last = table.rowAtPoint(new Point(0, viewRect.y + viewRect.height - 1));
    if (last == -1)
    {
        last = tableModel.getRowCount() - 1; // Handle empty space below last row
    }

    for (int i = first; i <= last; i++)
    {
        int row = sorter.convertRowIndexToModel(i); // or: row = i
        //... Do stuff with each visible row
    }

    if (last == tableModel.getRowCount() - 1) {} //... Last row is visible
}