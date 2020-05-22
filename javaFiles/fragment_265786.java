private static class MyExceptionHandler extends ExceptionHandlerWrapper {
    private ExceptionHandler parent;

    public WfExceptionHandler(ExceptionHandler parent) {
      this.parent = parent;
    }

    @Override
    public ExceptionHandler getWrapped() {
      return this.parent;
    }

    @Override
    public void handle() throws FacesException {
      for (Iterator<ExceptionQueuedEvent> i =
           getUnhandledExceptionQueuedEvents().iterator();
           i.hasNext();) {
        ExceptionQueuedEvent event = i.next();
        i.remove();
        ExceptionQueuedEventContext context =
          (ExceptionQueuedEventContext) event.getSource();
        Throwable t = context.getException();
        myProcessing(t);
      }
    }
    ...
  }