@Bean
public HttpHandler myRoute(MyHandler handler) {
    final RouterFunction<ServerResponse> routerFunction =
        route(POST("/myResource"), handler::persistNotification);
    return webHandler(toWebHandler(routerFunction))
        .filter(new TracingFilter())
        .build();
}