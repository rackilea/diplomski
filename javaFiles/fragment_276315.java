this.vertx.setPeriodic(
      1000,
      id -> {
          counter += 1;
          LOGGER.info("invoked method {}", counter);
          vertx.executeBlocking(
                new YourBlockingHandler(this.counter, this.service),
                res -> LOGGER.info(String.format("The result is: %s", res.result()))
          );
      }
);