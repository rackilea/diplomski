public static void main(String args[]) throws IOException, IllegalAccessException {
        ObjectMapper map = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.ALWAYS);
        Model testModel = new Model();

        instantiateFields(testModel);

        String result = map.writerWithDefaultPrettyPrinter().writeValueAsString(testModel);
        System.out.println(result);
    }

    private static void instantiateFields(Object o) throws IllegalAccessException {
        Field[] fields = o.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);

            if (field.get(o) == null) {
                Type type = field.getType();

                try {
                    Class<?> clazz = (Class<?>) type;
                    Object instance = clazz.newInstance();

                    if (List.class.isAssignableFrom(clazz)) {
                        instantiateList(clazz, field, instance);
                    }

                    field.set(o, instance);
                    instantiateFields(instance);

                } catch (ClassCastException | InstantiationException e) {
                    // Handle this or leave field null
                }
            }
        }
    }

    private static void instantiateList(Class<?> clazz, Field field, Object instance) throws IllegalAccessException, InstantiationException {
        ParameterizedType listType = (ParameterizedType) field.getGenericType();
        Class<?> listClass = (Class<?>) listType.getActualTypeArguments()[0];

        Object listTypeInstance = listClass.newInstance();

        instantiateFields(listTypeInstance);

        List<Object> list = (List<Object>) instance;
        list.add(listTypeInstance);
    }