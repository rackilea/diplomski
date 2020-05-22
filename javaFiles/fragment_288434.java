JList list = new JList(dataModel);
...
MouseListener mouseListener = new MouseAdapter() 
{
    public void mouseClicked(MouseEvent e) 
    {
        if (e.getClickCount() == 2) // double click?
        {
            int posicion = list.locationToIndex(e.getPoint());
            list.setSelectedIndex(posicion);
        }
        else if (e.getClickCount() == 1) // single click?
            list.clearSelection() ;
    }
};
list.addMouseListener(mouseListener);