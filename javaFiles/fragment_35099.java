// Logging Interceptor..
public class LoggingInterceptor extends EmptyInterceptor {

   private static final long serialVersionUID = 1L;
   // Define a static logger
   private static Logger logger = LogManager.getLogger(LoggingInterceptor.class);

    // 1) save
   @Override
   public boolean onSave(Object entity, Serializable id, Object[] state,
            String[] propertyNames, Type[] types) 
   {
      logger.info("onSave method is called.");
      System.out.println("LoggingInterceptor . onSave() before save this method is called.");
      if (entity instanceof Book) {
         Book book = (Book) entity;
         logger.info(book.toString());
      }
      return super.onSave(entity, id, state, propertyNames, types);
   }