Class<TestDto> klazz = TestDto.class;
    try {
        Method method = klazz.getDeclaredMethod("test", Map.class);
        Type type = method.getGenericParameterTypes()[0];
        System.out.println("Type: " + type);
    } catch (NoSuchMethodException ex) {
        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SecurityException ex) {
        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
    }

    Type: java.util.Map<java.lang.Double, java.lang.Integer>