@Controller
@SessionAttributes({"user"})
public class InspectionTypeController {

   @RequestMapping(value="/addInspectionType.htm", method = RequestMethod.POST )
   public void addInspectionType(InspectionType inspectionType, @ModelAttribute User user) {
      System.out.println("User: "+ user.getUserDetails().getFirstName);
   }
}