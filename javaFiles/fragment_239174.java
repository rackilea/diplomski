HttpHandler httpHandler = WebHttpHandlerBuilder.webHandler(toHttpHandler(routerFunction))
  .prependExceptionHandler((serverWebExchange, exception) -> {

      /* custom handling goes here */
      return null;

  }).build();