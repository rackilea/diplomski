@Intercepts({
    @Signature(type = Executor.class,
    method = "query",
    args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class ConfigPropInterceptor implements Interceptor {

    private final Map<String, Object> properties = new HashMap<String, Object>();

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object param = invocation.getArgs()[1];
        if (param instanceof Map) {
            ((Map<String, Object>)param).putAll(properties);
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        for (String p : properties.stringPropertyNames()) {
            this.properties.put(p, properties.getProperty(p));
        }
    }
}