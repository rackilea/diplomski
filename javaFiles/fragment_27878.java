@RestController("/injuries")
public class InjuryController {

  @Autowired
  private InjuryToDTOConverter converter;

  @Autowired
  private InjuryService injuryService;

  @GetMapping
  public InjuryDTO getInjury(){
    Injury injury = injuryService.getInjury();
    return converter.convert(injury);
  }
}