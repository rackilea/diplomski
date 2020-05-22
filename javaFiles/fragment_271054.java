Map<String,Object> beans = applicationContext.getBeansWithAnnotation(Service.class);
    for (Map.Entry<String, Object> entry : beans.entrySet()){
        Class<?> clazz = entry.getValue().getClass();
        //System.out.println(clazz.getName());
        String[] split = clazz.getName().split("\\$");
        String realClassName = split[0];
        //System.out.println(realClassName);
        Class<?> myClass = getClass().getClassLoader().loadClass(realClassName);
         Method[] methods = myClass.getDeclaredMethods();
        for(Method method: methods) {
            for (Annotation a : method.getAnnotations()){
                System.out.println(a.toString());
            }
        }
    }