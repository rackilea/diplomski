public class Person {
    private String name;
    private String age;
    private String birthday;

    public Person(String name, String age, String birthday)
    {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public String toString()
    {
        String information = "Name: " + name + "\nAge: " + age + "\nBirthday: " + birthday;
        return information;
    }
}