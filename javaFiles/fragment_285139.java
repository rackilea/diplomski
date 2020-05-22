try {
        Class<?> util = Class.forName("com.example.project.Util");
        Object newInstance = util.newInstance();
        Method method = util.getDeclaredMethod("getPlatform");
        String platform = (String) method.invoke(newInstance);
        System.out.println("Platform: " + platform));
    } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
        Logger.getLogger(BasicView.class.getName()).log(Level.SEVERE, null, ex);
    }