@Named("helloWorld")   //@Model was not available in my project
 public class HelloWorldBean {

    private String name;

    //Getters and Setters

    Logger LOG = LoggerFactory.getLogger(HelloWorldBean.class);

    public void convertNameToUpperCase2(AjaxBehaviorEvent event) {
         LOG.debug("Inside Bean");
         name = name.toUpperCase();
    }
 }