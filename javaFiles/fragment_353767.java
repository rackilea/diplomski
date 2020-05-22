@Configuration
public class MyAppConfig {

   @Autowired private MyType somethingToAutowire;

   @Bean
   public ICommandHandler iCommandHandler(@Value("${datasource.connectionString}") 
                                                  final String connectionString) {

       return new DeadlockRetryCommandHandlerDecorator<MoveCustomerCommand>();

       // You obviously have access to anything autowired in your configuration
       // class.  Then you can @Autowire a ICommandHandler type into one of your 
       // beans and this method will be called to create the ICommandHandler (depending on bean scope)

   }
}