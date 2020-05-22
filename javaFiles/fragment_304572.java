@Statless
public class ServiceB {

  @Inject GenericStorageService store;
  @Inject TransactionalService transactionalService;

  public void insertIfNotYetPresent(B ety) {
    try {   
      transactionalService.executeTransactional(() -> store.insert(ety) ); 
      transactionalService.executeTransactional(() -> someSideEffect() );

    } catch (UniqueConstraintViolation e) {
      // that's totally ok
    }
  }
}