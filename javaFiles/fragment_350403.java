apiResultStream
  .doOnEach(next -> {
    if (next) logger.info("Logging true " + next);
    else  logger.info(Logging false " + next);
  })
  .subscribe(....