T item = null;
    try {
        JAXBContext context = JAXBContext.newInstance(Configuration.class);
        Unmarshaller um = context.createUnmarshaller();
        Configuration conf = (Configuration) um.unmarshal(xmlFile);
        Method[] allMethods = Configuration.class.getDeclaredMethods();
        for (Method method : allMethods)
        {
            if (method.getReturnType().equals(clazz))
            {
                item = (T) method.invoke(conf);
                break;
            }
        }
    } catch (JAXBException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
        throw new ConfigException("Failure detected while loading configuration", e);
    }
    return item;