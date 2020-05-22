@RestController
@RequestMapping(value = "services/")
public class GenericController  {

    @Autowired
    LabRepository labRepository;

    @Autowired
    ServerRepository serverRepository;

    @RequestMapping(value = "server", method = RequestMethod.POST)
    public Server create(@RequestBody Server server) {
        return serverRepository.saveAndFlush(server);
    }
}