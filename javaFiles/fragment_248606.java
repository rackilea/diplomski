private BooleanBuilder addCustomMapPredicates(MultiValueMap<String, String> parameters, Predicate predicate, Class<?> domainType) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        parameters.keySet()
                  .stream()
                  .filter(s -> s.contains("[") && matches(s) && s.endsWith("]"))
                  .collect(Collectors.toList())
                  .forEach(paramKey -> {
                      String property = paramKey.substring(0, paramKey.indexOf("["));
                      if (ReflectionUtils.findField(domainType, property) == null) {
                          LOGGER.warn("Skipping predicate matching on [%s]. It is not a known field on domainType %s", property, domainType.getName());
                          return;
                      }
                      String key = paramKey.substring(paramKey.indexOf("[") + 1, paramKey.indexOf("]"));
                      parameters.get(paramKey).forEach(value -> {
                          if (!StringUtils.hasLength(value)) {
                              booleanBuilder.or(matchesProperty(key, null));
                          } else {
                              booleanBuilder.or(matchesProperty(key, value));
                          }
                      });
                  });
        return booleanBuilder.and(predicate);
    }

    static boolean matches(String key) {
        return PATTERN.matcher(key).matches();
    }