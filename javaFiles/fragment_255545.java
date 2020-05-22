// Without DI:
public class BankService {
   private AbstarctFactory factory= new Parser1Factory();
   public void depositFundsFromFile(File file){
      //  use factory
   }
}
// With DI:
public class BankService {
   @Autowired
   private AbstarctFactory factory; // will be injected by the framework
   public void depositFundsFromFile(File file){
      //  use factory
   }
}