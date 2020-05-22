private void injectFieldsIntoPresenter(FXMLLoader loader, P presenter) throws IllegalArgumentException, IllegalAccessException  {
    Map<String, Object> namespace = loader.getNamespace() ;
    for (Field field : presenter.getClass().getDeclaredFields()) {
        boolean wasAccessible = field.isAccessible() ;
        field.setAccessible(true);
        if (field.getAnnotation(FXML.class) != null) {
            if (namespace.containsKey(field.getName())) {
                field.set(presenter, namespace.get(field.getName()));
            }
        }
        field.setAccessible(wasAccessible);
    }
}