private void initializePresenterIfPossible(P presenter) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    for (Method m : presenter.getClass().getDeclaredMethods()) {
        boolean wasAccessible = m.isAccessible() ;
        m.setAccessible(true);
        if ("initialize".equals(m.getName()) && m.getParameterCount() == 0) { 
            if ((m.getModifiers() & Modifier.PUBLIC) != 0 || m.getAnnotation(FXML.class) != null) {
                m.invoke(presenter);
            }
        }
        m.setAccessible(wasAccessible);
    }
}