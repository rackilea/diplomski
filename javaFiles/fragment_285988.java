@SessionScoped
@Named
public class MySessionController implements Serializable{
  //simple, just inject and the producer method will be called automatically
  @Inject
  private MyService service;
}