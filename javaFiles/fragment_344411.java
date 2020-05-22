class MyAction implements Action {

    @Inject
    protected MyAction() {
        //noop
    }


    @Override
    public void execute() throws ActionExecutionException {
        System.out.println("Yo!");
    }
}