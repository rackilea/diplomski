public class RoutesBuilder extends FatJarRouter {

....

@Bean(name={"restlet"})
    public RestletComponent restlet()
    {
        .......
    }

@Override
    public void configure() throws JAXBException {
    ......
}


}