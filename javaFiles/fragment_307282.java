final LongProperty timeOfLastExecute = new SimpleLongProperty(System.currentTimeMillis());

mapScroll.addEventFilter(MouseEvent.MOUSE_DRAGGED, e -> {
        if(System.currentTimeMillis() - timeOfLastExecute.get() > 10) {
            endX = e.getX();
            endY = e.getY();
            Bounds viewBounds = mapScroll.getViewportBounds();
            double startEndX = startX - endX;
            double startEndY = startY - endY;

            Bounds contentBounds = mapScroll.getContent().getLayoutBounds();

            double hChange = startEndX / (contentBounds.getWidth() - viewBounds.getWidth());
            double vChange = startEndY / (contentBounds.getHeight() - viewBounds.getHeight());
            mapScroll.setHvalue(mapScroll.getHvalue() + hChange);
            mapScroll.setVvalue(mapScroll.getVvalue() + vChange);

            startX = endX;
            startY = endY;
            timeOfLastExecute.set(System.currentTimeMillis());
        }
    });