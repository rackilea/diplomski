@Controller
@RequestMapping("/")
public class RootController
{

  @RequestMapping(method=RequestMethod.GET)
  public String index()
  {
    return "index";
  }

}