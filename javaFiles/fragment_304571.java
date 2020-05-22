//So generic transaction service, that commits every transaction in a different transaction context.
@Stateless
@TransactionAttribute(REQUIRES_NEW)
public class TransactionalService {

   public void executeTransactional(final Runnable task) {
     task.run();
   }
}

@Statless
public class ServiceB {

  @Inject GenericStorageService store;
  @Inject TransactionalService transactionalService;

  public void insertIfNotYetPresent(B ety) {
    try {       
      transactionalService.executeTransactional(new Runnable() {
         public void run() {
            store.insert(ety);
         }
      };

      transactionalService.executeTransactional(new Runnable() {
         public void run() {
            someSideEffect();
         }
      };

    } catch (UniqueConstraintViolation e) {
      // that's totally ok
    }
  }
}