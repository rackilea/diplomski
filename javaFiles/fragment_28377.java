@Controller
public class yourCustomController {

//this will be your home page
@RequestMapping(value ="/")
public String showHomePage(){
//the return statement will look in the path defined in the view resolver and add the .jsp suffix ( so it will display file "/web-inf/view/my-home-page.jsp" )
  return "my-home-page";
}
}