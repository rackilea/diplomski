@ManagedBean()
@RequestScoped
public class SomeOtherBean {
   @ManagedProperty(value="#{myBean}") 
   private MyBean myBean;
   //getters & setters of myBean