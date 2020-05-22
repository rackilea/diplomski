public void genericMethod(JPanel p, JTable t, TableDbCallBack tableDb)
{
    if(p.getComponentCount()==0)
    {
        tableDb.run();
    }
    if(isSelected)
    {
        selection(t);
    }
   else
   {
        t.setColumnSelectionAllowed(false);
        t.setRowSelectionAllowed(false);
        t.setCellSelectionEnabled(false);
        Rselection(t);
    }
}