pause.setOnFinished(e -> {
        Node theTab = tabPane.lookup("#myTab");
        // contextMenu.show(theTab, Side.RIGHT, 0, 0);
        Bounds tabBounds = theTab.getBoundsInLocal();
        double centerX = tabBounds.getMinX() + tabBounds.getWidth()/2;
        double centerY = tabBounds.getMinY()+tabBounds.getHeight()/2;
        Point2D location = theTab.localToScreen(centerX, centerY);
        double x = location.getX();
        double y = location.getY();
        Event event = new ContextMenuEvent(ContextMenuEvent.CONTEXT_MENU_REQUESTED, centerX, centerY, x, y, false, new PickResult(theTab, x, y));
        Event.fireEvent(theTab, event);
    });