Method[] methods = entity.getClass().getMethods();
    Map<String, String> map = new HashMap<String, String>();
    for(Method m : methods)
    {
        if(m.getName().startsWith("get"))
        {
            String value = (String) m.invoke(entity);
            map.put(m.getName().substring(3), value);
        }
    }