@Component("myService")
public class MyServiceImpl implements MyService {
  @ApplyAuthorisationAdvice 
   public List<MySummary> search(MyContext searchContext) {
   }
}