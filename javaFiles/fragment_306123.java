siteIdToAppNameToAppMap.values()
   .stream()
   .flatMap(m -> m.values().stream())
   .collect(
        Collectors.toMap(App::getToken, Function.identity())
   );