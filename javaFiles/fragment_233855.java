if(wwHandler != null) {
    wwHandler.addMouseMotionListener(new MyMouseMotionListener());
} else {
    // I don't think this should happen unless the AWTInputHandler
    // is explicitly removed by client code
    logger.error("Couldn't find AWTInputHandler");
}