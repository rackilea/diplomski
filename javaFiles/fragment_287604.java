@javax.faces.bean.ManagedBean(name="helloWorld")
 @javax.enterprise.context.RequestScoped
 public class HelloWorldBean {

private String name;

// Getters and Setters

// Logger LOG = LoggerFactory.getLogger(HelloWorldBean.class);

public void convertNameToUpperCase2(AjaxBehaviorEvent event) {
    // LOG.debug("Inside Bean");
    name = name.toUpperCase();
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}
}