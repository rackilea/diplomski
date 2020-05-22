Model model = new Model();

FXMLLoader loader = new FXMLLoader(getClass().getResource("/path/to/fxml/file"));

loader.setControllerFactory((Class<?> controllerType) -> {
    try {
        for (Constructor<?> con : controllerType.getConstructors()) {
            if (con.getParameterCount() == 1 && con.getParameterTypes()[0]==Model.class) {
                return con.newInstance(model);
            }
        }
        // no suitable constructor found: just return default instance
        return controllerType.newInstance();
    } catch (Exception e) {
        System.err.println("Warning: could not load controller");
        e.printStackTrace(System.err);
        return null ;
    }
});