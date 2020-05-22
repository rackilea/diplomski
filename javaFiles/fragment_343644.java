new SelectionAdapter()
{
    @Override
    public void widgetSelected(SelectionEvent e)
    {
        String typex = combo_2.getText();
        String typey = combo_1.getText();
        System.out.println(typex + " " + typey);
    }
}