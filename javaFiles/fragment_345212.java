@ManagedBean
public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private String resultMessage;

    // Setters/Getters for firstName, lastName, age and resultMessage

    public String concatMyInfo() {
        resultMessage = "My name is : " + firstName + " " + lastName + " ... and my age is :" + age;
        return "result";
    }
}