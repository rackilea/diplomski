class MyJTable extends JTable
{
    public boolean isCellEditable(int arg0, int arg1) {
        return true;
    }
}
table = new MyJTable;