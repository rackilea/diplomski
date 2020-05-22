Arrays.stream(resources)
     .map(this::ingestFromFile)
     .map(Container.class::cast)
     .map(Container::getAll)
     .flatMap(Collection::stream)
     .forEach(
            dataType -> {
              loaderConstants.getRepo(dataType.toString()).save(dataType);
              LOGGER.log(Level.INFO, "Saved: " + dataType);
     });