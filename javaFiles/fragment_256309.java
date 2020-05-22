@Controller
public class SpringController {

    @RequestMapping(value = "/updateItems", method = RequestMethod.POST)
    public ArrayList<String> updateItems(@RequestBody List<String> updatedItems) {
       System.out.println(updatedItems);
       // do sth
       return null;
    }
}