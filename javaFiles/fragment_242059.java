private fun deploy(clazz: Class<out AbstractVerticle>) {
  vertx.deployVerticle(clazz.name, DeploymentOptions(config().getJsonObject(clazz.name) ?: JsonObject())) { handler ->
    if (handler.succeeded()) {
      logger.debug("${clazz.simpleName} started successfully (deployment identifier: ${handler.result()})")
    } else {
      logger.error("${clazz.simpleName} deployment failed due to: ${handler.cause()}")
      //stop();
    }
  }
}