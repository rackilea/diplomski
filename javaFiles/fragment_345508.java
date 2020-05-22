for (int i = 0; i < dm.getRowCount(); i++)
{
    // reallocate the array
    arr = new Object[dm.getColumnCount()];
    for (int j = 0; j < arr.length; j++)
    {
        arr[j] = dm.getValueAt(i, j);
        //arr[j] here is the value as it should be 
    }
    data.put(Integer.toString(i), arr);
}