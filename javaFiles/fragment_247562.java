private void makeItemRightClickListener()
{
    grid.addCellPreviewHandler(new CellPreviewEvent.Handler<T>() {
        @Override
        public void onCellPreview(CellPreviewEvent<T> event)
        {
            if (event.getNativeEvent().getButton() !=
                        NativeEvent.BUTTON_RIGHT)
                return;

            // Prevent browser's own context menu from appearing
            event.getNativeEvent().preventDefault();
            event.getNativeEvent().stopPropagation();

            handleItemRightClickEvent(event);
        }
    });
}

private void handleItemRightClickEvent(CellPreviewEvent<T> event)
{
    NativeEvent nativeClickEvent = event.getNativeEvent();
    // Get the data (type T) that is being displayed in the cell
    // by the CellTable or DataGrid widget.
    T rowClicked = event.getValue();

    // Create PopupPanel for menu
    PopupPanel popup = ...

    // Show the popup menu at the click position
    UIObject target = new MousePointUIObject(nativelickEvent);
    popup.showRelativeTo(target);
}

private static class MousePointUIObject extends UIObject
{
    private NativeEvent mouseEvent;

    public MousePointUIObject(NativeEvent mouseEvent)
    {
        this.mouseEvent = mouseEvent;
    }

    @Override
    public int getAbsoluteLeft()
    {
        return mouseEvent.getClientX() + Window.getScrollLeft();
    }

    @Override
    public int getAbsoluteTop()
    {
        return mouseEvent.getClientY() + Window.getScrollTop();
    }

    @Override
    public int getOffsetWidth()
    {
        return 0;
    }

    @Override
    public int getOffsetHeight()
    {
        return 0;
    }
}