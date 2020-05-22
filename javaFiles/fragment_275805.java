@Service
public class ChargesDataService{

  @Autowire
  private ChargesRepository chargesRepository;

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public Charge saveCharge(Charge charge) {
    return chargesRepository.saveAndFlush(charge);
  }
}

@RestController
public class ChargesController{

  @Autowire
  private ChargesDataService chargesDataService;

  @Transactional
  public void importChargesRequest() {

   for (Charge charge : charges) {

      try {
        Charge savedCharge = chargesDataService.saveCharge(charge);
      } catch (Exception e) {
        log.error(e.getMessage());
      }
    }
  }
}