loader.setControllerFactory(new Callback<Class<?>, Object>() {
    @Override
    public Object call(Class<?> c) {
        return applicationContext.getBean(c);
    }
});