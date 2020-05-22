@Service
@Transactional
public class InterventionProjectResultIntegrator implements IInterventionProjectResultIntegrator {

  private static final ILogger logger = ComponentLogger.getInstance(InterventionProjectResultIntegrator.class);

  private Dao dao;
  private String APPLICATION = "APP";

  @Autowired
  public void setDao(Dao dao){
    this.dao = dao; 
  }

  @Override
  public void integrateResponse() {

    try {
      List<ResponseEntity> responseListByStatus = dao.findAllResponseByStatus(Dao.STATUS_EN_COURS, APPLICATION);

      for (ResponseEntity response: responseListByStatus ) {
        response.setStatus(Dao.STATUS_OK);
        dao.mergeResponseEntity(response);
      }
    } catch (Exception ex) {
      logger.error(ex.getMessage(), ex);
      throw ex;
    }
  }
}