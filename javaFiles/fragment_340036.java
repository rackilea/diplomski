HashMap<String, Object> element = (HashMap<String, Object>) ((ArrayCollection) v).get(0);
    ClassPool pool = ClassPool.getDefault();
    CtClass ctClass = pool.makeClass("Dynamic"+System.currentTimeMillis());
    element.keySet().forEach(s -> {
    try {
    //need only Strings
    ctClass.addField(CtField.make("public String "+s+";", ctClass));
    ctClass.addMethod(CtMethod.make("public String get" + StringUtils.capitalize(s) + "() { return " + s + "; }", ctClass));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    Class clazz = ctClass.toClass();
    ArrayList<Object> objects = new ArrayList<>();
    ((Collection) v).forEach(m -> {
        HashMap<String, Object> hm = (HashMap<String, Object>) m;
        try {
            Object obj = clazz.newInstance();
            element.keySet().forEach(s -> {
                try {
                    obj.getClass().getDeclaredField(s).set(obj, hm.get(s));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        objects.add(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    });
    parameters.put(k, new JRBeanCollectionDataSource(objects));