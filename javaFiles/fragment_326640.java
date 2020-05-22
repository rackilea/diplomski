@Service
@RequiredArgsConstructor //Lombok
public class SomeService {

   private final String someValue;
   public SomeService(@Value("${value.to.be.injected}") String someValue, other stuff....) { 
     this.someValue=someValue;
   }
}