public class ResultMapInterceptor implements Interceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResultMapInterceptor.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object target = invocation.getTarget();
        DefaultResultSetHandler defaultResultSetHandler = (DefaultResultSetHandler) target;
        Field field = ReflectionUtils.findField(DefaultResultSetHandler.class, "mappedStatement");
        ReflectionUtils.makeAccessible(field);
        MappedStatement mappedStatement = (MappedStatement) field.get(defaultResultSetHandler);
        String className = StringUtils.substringBeforeLast(mappedStatement.getId(), ".");
        String methodName = StringUtils.substringAfterLast(mappedStatement.getId(), ".");

        Method[] methods = Class.forName(className).getDeclaredMethods();
        if (methods == null) {
            return invocation.proceed();
        }

        // get method "mappedStatement"
        for (Method method : methods) {
            if (methodName.equalsIgnoreCase(method.getName())) {
                // get annotation ResultMap, if null, then proceed
                ResultMap resultMap = method.getAnnotation(ResultMap.class);
                if (resultMap == null) {
                    return invocation.proceed();
                }
                // convert result map to specify result
                Statement statement = (Statement) invocation.getArgs()[0];
                return convert2Map(statement);
            }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof ResultSetHandler) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {

    }

    private Object convert2Map(Statement statement) throws Throwable{
        ResultSet resultSet = statement.getResultSet();
        if (resultSet == null) {
            return null;
        }
        List<Object> resultList = new ArrayList(4);
        Map<Object, Object> map = new HashMap(8);
        while (resultSet.next()) {
            if (resultSet.getObject(1) != null) {
                map.put(resultSet.getObject(1), resultSet.getObject(2));
            }
        }
        resultList.add(map);
        LOGGER.debug("map result from DB, {}", resultList);
        return resultList;
    }