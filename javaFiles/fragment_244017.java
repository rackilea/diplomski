public class SomeService implements SomeInterface {

   private SomeDao thisDaoWrapsJdbcTemplate;
   private PlatformTransactionManager transactionManager;

   public void setTransactionManager( PlatformTransactionManager transactionManager ) {
      this.transactionManager = transactionManager;
   }

   public void doBusiness( Business: business ) {

      TransactionDefinition def = new DefaultTransactionDefinition();
      TransactionStatus status = transactionManager.getTransaction( def );

      try {

         // do business here
         Money money = Money.LOTS_OF
         ...
         // wire the money in..
         thisDaoWrapsJdbcTemplate.depositLotsOfMoney( money )

         transactionManager.commit( status );

      } catch ( DataAccessException dae ) {

         transactionManager.rollback( status );
         throw dae;
      }
      return;
   }