@Service
public class XaSftpSessionFactory {

   @Autowired
   private JtaTransactionManager transactionManager;

   public XaSftpSession getSession(final ConnectionSettings settings) {
      if (settings == null) {
           throw new IllegalArgumentException("The specified SFTP connection settings must be not null.");
      }

      final XaSftpSession xaSession = new XaSftpSession(settings);
      final XaSftpResource xaResource = new XaSftpResource(xaSession);
      xaSession.setXaResource(xaResource);

      XaSftpResourceProducer.registerXAResource(settings.getName(), xaResource);

      try {
           Transaction transaction = transactionManager.getTransactionManager().getTransaction();
           transaction.enlistResource(xaResource);
           transaction.registerSynchronization(
            new Synchronization() {
                @Override
                public void beforeCompletion() {
                }

                @Override
                public void afterCompletion( int status ) {
                    XaSftpResourceProducer.unregisterXAResource(settings.getName(), xaResource );
                }
            }
        );
       } catch (RollbackException | SystemException exception) {
          throw new IllegalStateException(
            String.format("Can't create an SFTP session for the '%s' instance.", settings.getName()),
            exception
        );
       }

       return xaSession;
   }
}