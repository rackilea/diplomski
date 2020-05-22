public class SalesPerson {

public SalesPerson(Integer id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
}

Integer id;
String firstName;
String lastName;

public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public String getFirstName() {
    return firstName;
}

public void setFirstName(String firstName) {
    this.firstName = firstName;
}

public String getLastName() {
    return lastName;
}

public void setLastName(String lastName) {
    this.lastName = lastName;
}

@Override
public String toString() {
    return "{" +
            "'id':" + id +
            ", 'firstName':'" + firstName + '\'' +
            ", 'lastName':'" + lastName + '\'' +
            '}';
}

public SalesPerson search(String search){
    if(firstName.matches("(.*)"+search+"(.*)") || lastName.matches("(.*)"+search+"(.*)")){
        return this;
    }
    return null;
}