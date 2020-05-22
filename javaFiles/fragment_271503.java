// Example router setup
Router router = Router.router(vertx);
router.route(HttpMethod.GET, "/").handler(routingContext -> {
    routingContext.response().end("Root");
});

router.route(HttpMethod.GET, "/users").handler(routingContext -> {
    routingContext.response().end("Post");
});

router.route(HttpMethod.POST, "/users").handler(routingContext -> {
    routingContext.response().end("Post");
});

// Getting the routes
for (Route r : router.getRoutes()) {
    // Path is public, but methods are not. We change that
    Field f = r.getClass().getDeclaredField("methods");
    f.setAccessible(true);
    Set<HttpMethod> methods = (Set<HttpMethod>) f.get(r);
    System.out.println(methods.toString() + r.getPath());
}