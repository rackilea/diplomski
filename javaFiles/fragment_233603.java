public Event buildEvent(String [] arguments) throws ClassNotFoundException {
    Class<?>[] argumentTypes = {};
    Object[] parameters = {};

    try {
        //define the class type from the first argument    
        Class<?> eventClass
                = Class.forName(packageName + arguments[0]);   
        if (arguments.length() > 1) {
            argumentTypes = new Class<?>[]{Long.TYPE};
            parameters = new Object[]{Long.parseLong(arguments[1])};

            Constructor<?> constructor
                    = eventClass.getDeclaredConstructor(argumentTypes);
            Object instance = constructor.newInstance(parameters);
            return ((Event) instance);
        //default 
        } else {
            Constructor<?> constructor
                    = eventClass.getDeclaredConstructor();
            Object instance = constructor.newInstance();
            return ((Event) instance);
        }
    } catch (ClassNotFoundException cnfe) {
        System.out.println("Class not available in this package.");
    } catch (NoSuchMethodException |
            SecurityException |
            InstantiationException |
            IllegalAccessException |
            IllegalArgumentException |
            InvocationTargetException e) {
        log.log(Level.SEVERE, "Class Builder: {0}", e.getMessage());
    }
    return null;
}