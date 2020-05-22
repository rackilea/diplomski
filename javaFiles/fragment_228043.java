Class<?> driverBinary = driverManager.get(driverClass);

    try {
        // Retrieves a no-arg method of the specified name, declared by the
        // driverBinary class
        Method getInstanceMethod = driverBinary.getDeclaredMethod("getInstance");

        // Invokes the (assumed static) method reflectively
        BrowserManager manager = (BrowserManager) getInstanceMethod.invoke(null);

        manager.setup();
    } catch ( IllegalAccessException
            | IllegalArgumentException
            | InvocationTargetException
            | NoSuchMethodException
            | SecurityException e) {
        // handle exception
    }