@Service
    public class RouteManager implements CamelContextAware { 

    protected CamelContext camelContext;

    public CamelContext getCamelContext() {
     return camelContext;
    }

    public void setCamelContext(CamelContext camelContext) {
     this.camelContext = camelContext;
    }
}