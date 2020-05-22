@ApplicationScoped
public class MyFactoryOrSupplier {

    @Produces
    @RequestScoped
    public IMyClass getMyClass(@Context HttpServletRequest request) {
        return (IMyClass) request.getAttribute("MyInjectedClass");
    }
}