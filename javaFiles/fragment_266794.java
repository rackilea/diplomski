@ControllerAdvice
public class PageAdvice{

    @Autowired
    private HeaderService s;

   @ModelAttribute("headerParam")
   public Object retriveHeaderParm(){
      return s.getObjectWithParam("a param");
   }
}