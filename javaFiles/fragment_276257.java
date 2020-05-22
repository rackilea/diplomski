public void stateChanged(ChangeEvent e)
{
    //  Sync the scroll pane scrollbar with the row header

    JViewport viewport = (JViewport) e.getSource();
    scrollPane.getVerticalScrollBar().setValue(viewport.getViewPosition().y);
}