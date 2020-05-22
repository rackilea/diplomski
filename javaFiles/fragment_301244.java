public class MyClass  {

    private Model1 model1;
    private Model2 model2;

    private JTable table1;
    private JTable table2;

    public void myMethod()
    {
        table1 = new JTable();
        model1 = new Model1();
        table1.setModel(model1);

        table2 = new JTable();
        model2 = new Model2();
        table2.setModel(model2);

        table1.getModel().addTableModelListener(new TableModelListener()
        {
            @Override
            public void tableChanged(TableModelEvent e) 
            {
                //Here some code to enable a button when at least one row is checked
                //that works fine
                Object aValue = "something"; //fill
                int row = 1; //fill
                int column = 1; //fill
                model2.setValueAt(aValue, row, column);
                model2.fireTableDataChanged();
            }
        });
    }
}