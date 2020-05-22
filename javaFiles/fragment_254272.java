protected final <T extends Collection> T getBeanFromSpringContext(String name, Class<T> requiredType) {
    if(springApplicationContext != null) {
        return springApplicationContext.getBean(name, requiredType);
    } else {
        return null;
    }
}