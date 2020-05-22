@RestController
public class CityController {

@Autowired 
CityService cityService;

@RequestMapping(value = "/cities", method = RequestMethod.POST) 
public String addCity(City city) { cityService.save(city); }

}