static final Map<Class<?>, BiConsumer<Entity, String>> ADDERS = new IdentityHashMap<>();
{{ 
    ADDERS.put(String.class,  Entity::addStringProperty);
    ADDERS.put(Integer.class, Entity::addIntegerProperty);
    //...
}}