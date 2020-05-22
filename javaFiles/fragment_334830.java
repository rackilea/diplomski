public class RoutesBuilder extends FatJarRouter {

....

@Override
    public void configure() throws JAXBException {
    ......
}

@Bean(name={"restlet"})
    public RestletComponent restlet()
    {
        .......
    }
}