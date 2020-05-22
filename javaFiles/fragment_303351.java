Method method;
    try {
        method = f.getClass().getDeclaredMethod("doThis");

        method.setAccessible(true);
        method.invoke(f);
    } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
            | InvocationTargetException e) {
        System.err.println("Opala, somethign went wrong here!");
    }