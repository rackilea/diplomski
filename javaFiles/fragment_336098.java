@Bean
@Primary
ActionRepository actionRepository(final ApplicationContext applicationContext,
        final Configuration configuration) {
    final var database = configuration.getString("...");

    Map<String, ActionRepository> beanMap = context.getBeansOfType(ActionRepository.class);

    for (Map.Entry<String, ActionRepository> entry : beanMap.entrySet()) {
        Database db = context.findAnnotationOnBean(entry.getKey(), Database.class);
        if (db != null && db.value().equals(database)) {
            return entry.getValue();
        }
    }
    throw new RuntimeException("Cannot find the bean...");
}