router.route().handler(ctx -> {
        // Probably you want to check some request properties
       if (isThrottled(ctx)) {
           ctx.response().setStatusCode(504).end();
       }
       else {
           // All is good, continue
           ctx.next();
       }
    });