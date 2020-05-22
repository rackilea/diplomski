public class Person {
private StringProperty name = new SimpleStringProperty();
private StringProperty surname = new SimpleStringProperty();
private StringProperty country = new SimpleStringProperty();

public Person(String name, String surname, String country){
    this.name.set(name);
    this.surname.set(surname);
    this.country.set(country);
}

public StringProperty nameProperty(){return name;}
public StringProperty surnameProperty(){return surname;}
public StringProperty countryProperty(){return country;}

}