try {
    Class appClass = Class.forName("com.apple.eawt.Application");
    Class params[] = new Class[]{Image.class};

    Method getApplication = appClass.getMethod("getApplication");
    Object application = getApplication.invoke(appClass);
    Method setDockIconImage = appClass.getMethod("setDockIconImage", params);
    setDockIconImage.invoke(application, ImageIO.read(Test.class.getResource("/javaapplication163/bunny.jpg")));

} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ClassNotFoundException | IOException ex) {
    ex.printStackTrace();
}