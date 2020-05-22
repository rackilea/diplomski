public Result index() {
    try {
        if (securityService.getCurrentSession(Controller.ctx()) == null) {
            return Results.ok(Play.application().getFile("/public/index/index.html"), true);
        } else
            return Results.ok(Play.application().getFile("/public/main.html"), true);
    } catch (Exception e) {
        return Results.ok(Play.application().getFile("/public/index/index.html"), true);
    }
}