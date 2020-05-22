public static HandlerResolver build(final Handler... handlers) {

    return new HandlerResolver() {
      @Override
      public List<Handler> getHandlerChain(PortInfo portInfo) {
        List<Handler> handlerChain = new ArrayList<Handler>();

        if (handlers != null) {
          for (Handler handler : handlers) {
            handlerChain.add(handler);
          }
        }
        return handlerChain;
      }
    };
  }