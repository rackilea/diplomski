class GridPanel extends JPanel
{
    void SetMouseListener(MouseListener newListener)
    {
        for(MouseListener ml : getMouseListeners())
            removeMouseListener(ml);
        addMouseListener(newListener);
    }
}

class ControlPanel extends JPanel
{
    GridPanel gameGrid;

    void OnRectangleButtonClicked(some stuff)
    {
        gameGrid.SetMouseListener(new PlaceRoomListener(gameGrid));
    }
}

class PlaceRoomListener extends MouseAdapter
{
    GridPanel gameGrid;

    //constructor, etc

    void OnClick(mouse event)
    {
        gameGrid.doCoolStuff();
        gameGrid.SetMouseListener(new PlaceTrapDoorListener());
    }
}

//etc