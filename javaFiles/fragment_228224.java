class MyClass implements ApplicationContextAware {
    ...
    public void execute(String actionName) {
        Action action = applicationContext.getBean(actionName);
        action.execute();
    }
    ...
}