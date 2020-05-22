Compute compute = //obtain RMI client stub somehow
compute.executeTask(new Task<String>() {
    public String execute(GlobalContext globalContext) {
        //Note that this code is executed on the server and
        //getFoo() is implemented on the server side. We only know its interface
        globalContext.getFoo();
        //...
    }
}