JsonObject currentVertical = verticalArray.getJsonObject(indexCurrentDeploy);
    ObservableFuture<String> observable = RxHelper.observableFuture();
    currentVertical.forEach(entry -> {
    logger.debug("Starting deploy of class: " + entry.getKey() + ", With the config: " + entry.getValue() + ".");

        DeploymentOptions optionsDeploy = new DeploymentOptions().setConfig(jsonObjectConfig);

        vertx.deployVerticle(entry.getKey(), optionsDeploy, observable.toHandler());
    });

    observable.subscribe(id -> {
        logger.info("Class " + id + " deployed.");
        if (indexCurrentDeploy + 1 < verticalArray.size()) {
            deployAsynchronousVerticalByIndex(vertx, indexCurrentDeploy + 1, verticalArray, startFuture, jsonObjectConfig);
        } else {
            logger.info("ALL classes are deployed.");

            if (startFuture.isComplete()) {
                startFuture.complete();
            }
        }
    }, err -> {
        logger.error(err, err);
        startFuture.fail(err.getMessage());
    });