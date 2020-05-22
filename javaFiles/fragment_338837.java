void handleException(final Exception e) {
    if (handlers.containsKey(e.getType())
    {
        handlers[e.getType()].handle(e);
    }
    else
    {
         defaultHandler.handle(e);
    }
}