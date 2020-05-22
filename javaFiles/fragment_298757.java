//Client side
@Component
@FeignClient(name = ServiceID.TACHE)
@RibbonClient(name = ServiceID.TACHE)
public interface ITacheService extends ITache {
@RequestMapping(value = TACHE_CONTROLLER + "/save", produces = {"application/json; charset=UTF-8"},method = RequestMethod.POST)
    @ResponseBody
    HashMap<String, Object> save(@RequestBody HashMap<String,Object> map);
}

@Controller
@RequestMapping("/task")
public class TaskController {

// Server side
    @RequestMapping(value = "/save", produces = {"application/json; charset=UTF-8"},method = RequestMethod.POST)
    @ResponseBody
    HashMap<String, Object> save(@RequestBody HashMap<String, Object> map) throws ParseException { }
}