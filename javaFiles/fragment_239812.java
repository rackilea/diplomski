ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
FilterBuilder filterBuilder = new FilterBuilder();

configurationBuilder.addUrls(ClasspathHelper.forPackage(PACKAGE_TO_SCAN));
filterBuilder
        .includePackage(PACKAGE_TO_SCAN)
        .excludePackage(PACKAGE_TO_EXCLUDE);
configurationBuilder.filterInputsBy(filterBuilder);

Reflections reflections = new Reflections(configurationBuilder);