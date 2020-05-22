public void mouseExited(MouseEvent e) 
{
    if (! getVisibleRect().contains(e.getPoint()) )
    {
        setBackground(...);
    }
}