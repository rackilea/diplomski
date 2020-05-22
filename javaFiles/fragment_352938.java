class ExampleService() {

    private Dependency dep;

    @Inject
    public ExampleService(Dependency dep) {
        this.dep = dep;
    }

}

class Dependency {

    @Produces
    public static Dependency getInstance() {
        return new Dependency();
    }

    private Dependency() {
       /*constructor implementation here*/
    }

}