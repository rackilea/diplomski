private void init() {
    List<Handler> handlers = new ArrayList<Handler>();
    handlers.add(new VideoHandler());
    // add other handlers
}

public void someMethod(Jlist dorm) { 
    Object item = dorm.getSelectedValue();
    for(Handler handler : handlers) {
        if (item instanceof handler.getCategory()) {
            // optionally catch IllegalArgumentException here 
            handler.handle(item);
        }
    }
}