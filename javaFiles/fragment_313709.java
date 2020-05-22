public class CustomTableModel extends DefaultTableModel
{
    @Override
    public void setRowCount(int rowCount)
    {
        if (rowCount < getRowCount())
        {
            for (int i = getRowCount()-1; i >= rowCount; i--)
            {
                ((CustomPanel)getValueAt(i, 0)).removeListeners();
            }
        }
        super.setRowCount(rowCount);
    }
}