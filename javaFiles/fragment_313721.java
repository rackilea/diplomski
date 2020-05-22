public Object invokeMethod(Object service, Method method, RoutingContext routingContext) throws Exception {
        MultiMap queryParams = routingContext.queryParams();
        Map<String, String> pathParams = routingContext.pathParams();
        Buffer body = routingContext.getBody();

        // 1. type, 2. name, 3. value
        List<Tuple3<Class<?>, String, Object>> list = List.empty();

        for (Parameter par : method.getParameters()) {
            ParamQuery paramQuery = par.getAnnotation(ParamQuery.class);
            if (paramQuery != null) {
                list = list.push(new Tuple3<Class<?>, String, Object>(par.getType(), paramQuery.value(),
                        queryParams.get(paramQuery.value())));
            }
        }

// TypeConverterManager used to "covnert" each object (String) from the HTTP call to the correct data type
        return method.invoke(service, list.reverse()
                .map(mapper -> TypeConverterManager.lookup(mapper._1()).convert(mapper._3())).toJavaArray());
    }