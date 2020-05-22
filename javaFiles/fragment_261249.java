public static void register(Class<? extends SystemServiceCreator<?>> clazz) {
    if (!clazz.isAnnotationPresent(SystemService.class)) {
        throw new RuntimeException(
                "SystemServiceCreator must be implement SystemService");
    }
    SystemService systemService = clazz.getAnnotation(SystemService.class);
    final String name = systemService.value();
    if (name == null || name.length() == 0) {
        throw new RuntimeException("SystemService has incorrect name");
    }
    MAP.put(name, clazz);
}