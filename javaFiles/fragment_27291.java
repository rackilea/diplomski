@Service 
public class CityService {

@Autowired 
CityRepository cityRepository;

public City save(City city) {   cityRepository.save(city); }

}