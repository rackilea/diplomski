public class Person{
    @Parsed
    String id;

    @Parsed
    String name;

    @Parsed
    @Format(formats = "dd-MM-yyyy") //notice that multiple formats are supported
    Date birthDate;
}