Set<Whatever> result = list.stream()
    .filter(a -> !StringUtils.isEmpty(a.getProp1()))
    .filter(a -> !a.getProp1().matches("(.*)xyz"))
    .filter(a -> {
        try {
            return isValid(a.getProp1());
        } catch (javax.naming.NamingException e) {
            logger.error("Error");
            return false;
        }})
    .collect(Collectors.toCollection(HashSet::new));