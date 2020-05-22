router.route().handler(CookieHandler.create());
router.route().handler(BodyHandler.create());
router.route().handler(SessionHandler....);
router.route().handler(ctx -> {
  ctx.fail(404);
});