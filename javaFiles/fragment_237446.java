// Wrapper arround ConcurrentHashMap for the cached values
// An instance of that class will be a field in the subclass of Example
public static class ConfigCache {
    private Map<String, Object> values = new ConcurrentHashMap<>();

    public Object computeIfAbsent(String key, Function<String, Object> mappingFunction){
        return values.computeIfAbsent(key, mappingFunction);
    }
}

public static void main(String[] args) throws Exception {
    Class<? extends Example> clazz = new ByteBuddy().subclass(Example.class)
             // Add a field to the class
            .defineField(CONFIG_CACHE, ConfigCache.class, Visibility.PUBLIC, FieldManifestation.FINAL)
            // Add a constructor that initializes the field
            .defineConstructor(Modifier.PUBLIC).withParameter(ConfigCache.class).intercept(new FieldAssignConstructor())
            .method(ElementMatchers.nameStartsWith("get").or(ElementMatchers.nameStartsWith("is")))
            .intercept(MethodDelegation.to(Stack.class)) //
            .make()
            .load(ByteBuddyEnhancer.class.getClassLoader(), ClassLoadingStrategy.Default.INJECTION).getLoaded();

    Example example = clazz.getConstructor(ConfigCache.class).newInstance(new ConfigCache());
    example.getX();
}

// Use @FieldValue to access fields of a class  
@RuntimeType
public static Object intercept(@Origin Method method, @FieldValue(CONFIG_CACHE) ConfigCache cache){
    return cache.computeIfAbsent(method.getName(), key -> {
        // Do whatever you want here
        System.out.println("Computing for " + key);
        return null;
    });
}

private static final String CONFIG_CACHE = "configCache";