for (int i = 0; i < 4; i++)
{
    final TableColumn column = new TableColumn(table, SWT.NONE);
    column.setText("Column " + i);
    column.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event arg0)
        {
            System.out.println(column.getText());
        }
    });
}