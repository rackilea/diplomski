import javax.validation.constraints.Min;

@BirthdateConstraint
public class Person {

    @Min(value = 1) 
    public int age;

    public String birthdate;
}