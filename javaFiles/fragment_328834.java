@Bean
public class ExceptionFactory{
   @Autowired
   private MessageSource messageSource; 

   public MyBusinessException createMyBusinessException(String errorCode){        
      return new MyBusinessException(errorCode, messageSource.getMessage(this.code,null, Locale.ENGLISH));        
  } 
}