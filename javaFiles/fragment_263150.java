@Path("first")
public class FirstResource {
    @GET
    public String first() {
        return "first";
    }
}

@ApplicationPath("one")
public class JAXRSConfigurationOne extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(FirstResource.class);
        return resources;
    }
}

@Path("second")
public class SecondResource {
    @GET
    public String first() {
        return "second";
    }
}

@ApplicationPath("two")
public class JAXRSConfigurationTwo extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(SecondResource.class);
        return resources;
    }
}