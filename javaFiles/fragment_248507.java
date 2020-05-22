@Service
public class RESTServiceController {

    @RequestMapping("/restUrl")
    public @ResponseBody MyClass getResult() {
        return myClass;
    }
}