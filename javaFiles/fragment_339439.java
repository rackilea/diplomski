@Controller
@RequestMapping("/someresource")
public class SomeController
{
    @Autowired SomeService someService;

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public String getResource(Model model, @PathVariable Integer id)
    {
        //get resource via someService and return to view
    }

    @RequestMapping(method=RequestMethod.POST)
    public String saveResource(Model model, SomeResource someREsource)
    {
        //store resource via someService and return to view
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String modifyResource(Model model, @PathVariable Integer id, SomeResource someResource)
    {
        //update resource with given identifier and given data via someService and return to view
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteResource(Model model, @PathVariable Integer id)
    {
        //delete resource with given identifier via someService and return to view
    }
}