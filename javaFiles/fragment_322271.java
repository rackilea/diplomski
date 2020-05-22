class MyComponent { 
  public void getSomething(Handler<AsyncResult<String>> handler) {
    vertx.runOnContext(v -> {
      String result = someHeavyMethodInThisThread();
      handler.handle(Future.succeededFuture(result));
    });
  }
}