@Named public class ConfigurationBean {

     @Inject SoapFaultAnnotationExceptionResolver resolver;

  @PostConstruct public void initialise() {
     resolver.setWarnLogCategory("Dingbats"); 
  }
}