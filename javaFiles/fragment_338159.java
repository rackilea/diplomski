...
HandlerKey key = new HandlerKey(method, route, contentType);
RequestHandlerImpl handler = handlerMap.get(key);
if (handler == null) {
  // Error
}
...