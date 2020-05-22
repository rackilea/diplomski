@Controller
@RequestMapping("/map")
public class MapRest {

@Autowired
private MapService mapService;

@RequestMapping(value = "searchCarByUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<RetornoMapa> searchCarByUser(@RequestBody User user) {
//...