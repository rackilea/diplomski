public interface class Validator<T> {
  void validate(T t);
}

public class FirstEntityValidator implements Validator<FirstEntity> {
   public void validate(FirstEntity entity){
   ....
   }
}


public class SecondEntityValidator implements Validator<SecondEntity> {
   public void validate(SecondEntity entity){
   ....
   }
}

public interface EntityService{

 //your methods....

}

public class FirstEntityService implements EntityService{

    private FirstEntityValidator validator;

    public FirstEntityService(FirstEntityValidator validator){
        this.validator = validator;
    }

}