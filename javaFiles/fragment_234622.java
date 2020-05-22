public class Student {
private final String name;
private final String surname;
private final int age;
private final MailAddress mailAddress;

public Student(String name, String surname, int age, MailAddress mailAddress) {
    this.name = name;
    this.surname = surname;
    this.age = age;
    this.mailAddress=mailAddress;
}

 @Override
public String toString() {

    return String.format("name: %s surname:%s age:%d mail address:%s", name, surname, age, mailAddress);
}
}