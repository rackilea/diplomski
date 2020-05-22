return ok(
        JavaScriptReverseRouter.create("jsRoutes",
             routes.javascript.Users.list(),
             routes.javascript.Users.get()
        )
).as("text/javascript");