@Service
public class PersonService{

    @CustomValidation
    public void savePerson(@Validated Person person){        
       ....
    }

}