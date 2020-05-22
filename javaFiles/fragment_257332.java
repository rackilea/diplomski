import javax.validation.Validation;
import javax.validation.Validator;

import validation.AllStringsRegex;

@AllStringsRegex(value="l")
public class UnderValidation {
    String a;
    String b;

   public static void main(String... args) {
       UnderValidation object = new UnderValidation();
       object.a = "hello";
       object.b = "world";

       Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
       System.out.println(validator.validate(object));
   }
}