final Model model = new Model();

FXMLLoader loader = new FXMLLoader(getClass().getResource("path/to/fxml/file.fxml"));
loader.setControllerFactory(new Callback<Class<?>, Object>() {
    @Override
    public Object call(Class<?> type) {
        try {
             for (Constructor<?> constructor : type.getConstructors()) {
                 if (constructor.getParameterCount()==1 && 
                         constructor.getParameterTypes()[0]==Model.class) {
                     return constructor.newInstance(model);
                  }
             }
             // no matching constructor found, just call no-arg constructor as default:
             return type.newInstance();
        } catch (Exception exc) {
            exc.printStackTrace();
            return null ; // bail...
        }
    }
});
Parent root = loader.<Parent>load();