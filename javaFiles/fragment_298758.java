//Client side
@Component
@FeignClient(name = ServiceID.TACHE)
@RibbonClient(name = ServiceID.TACHE)
public interface ITacheService extends ITache {
@RequestMapping(value = TACHE_CONTROLLER + "/save", produces = {"application/json; charset=UTF-8"},method = RequestMethod.POST)
    @ResponseBody
    HashSet<String, Object> save(@RequestBody HashSet<String,Object> set);
}

@Controller
@RequestMapping("/task")
public class TaskController {

// Server side
    @RequestMapping(value = "/save", produces = {"application/json; charset=UTF-8"},method = RequestMethod.POST)
    @ResponseBody
    HashSet<String, Object> save(@RequestBody HashSet<String, Object> set) throws ParseException { }
}