boolean result = beginInvalidate();

try {
    //if the session was not already invalid, or in process of being invalidated, do invalidate
    if (result) {
         //tell id mgr to remove session from all contexts
         _handler.getSessionIdManager().invalidateAll(_sessionData.getId());
    }
}