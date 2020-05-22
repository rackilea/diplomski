//This is just a class to showcase the functionality
//I have not posted any codesnippers for this @CustomClassConstaint, 
//it is a custom annotaiton.
//I only included this annotation to show how  
//the CustomExceptionMapper handles annotations on a class level
@CustomClassConstaint 
public class TestClass {

    @NotNull
    @Size(min = 2, max = 5)
    public String testString1;

    @NotNull
    @Size(min = 2, max = 5)
    public String testString2;

    @Min(10)
    @Max(20)
    public int testInt1;

    @Min(10)
    @Max(20)
    public int testInt2;

}