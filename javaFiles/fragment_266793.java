public abstract class AbstractPage{

   @Autowired
   private HeaderService s;

   protected Object retrieveObjectWithParam(String param){
      return s.getObjectWithParam(param);
   }
}

@Controller
public class PageX1 extends AbstractPage{

  @RequestMapping("/test1")
  public String controller(Map<String, Object> model)  { 
    Object headerParam = retrieveObjectWithParam("a param");
    model.put("key" , headerParam);
  }
}