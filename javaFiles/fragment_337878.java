private void generateTablePopupMenu(int rowAtPoint)
{
    popupMenu.removeAll();

    if ( (rowAtPoint & 1) == 0 )
    {
        JMenuItem item = new JMenuItem("Even Row");
        popupMenu.add(item);}
    else
    {
        JMenuItem item = new JMenuItem("Odd Row");
        popupMenu.add(item);
    }

    popupMenu.revalidate();
}