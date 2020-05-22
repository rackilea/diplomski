@RestController
@RequestMapping(value = "/profile", produces = { MediaType.APPLICATION_JSON_VALUE })
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    public ProfileRepository getRepository() {
        return profileRepository;
    }

    // Notice that I've removed the 'profile' from here. It's enough to have it at class level
    @GetMapping("/{id}")
    Profile getProfileById(@PathVariable Long id) {
        return profileRepository.findById(id).get();
    }

    // Notice that I've removed the 'profile' from here. It's enough to have it at class level
    @PostMapping
    Profile createOrSaveProfile(@RequestBody Profile newProfile) {
        return profileRepository.save(newProfile);
    }
}