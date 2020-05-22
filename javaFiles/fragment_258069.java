@Entity
public class Address {
    @Id int id;  
    String street;
}


@SqlResultSetMapping(name="PersonDTOMapping",
    classes = {
     @ConstructorResult(targetClass = PersonDTO.class,
       columns = {@ColumnResult(name="name"), @ColumnResult(name="street")}
     )}
)
@Entity
public class Person {
    @Id int id;
    String name;
    Address address;  
}  

public class PersonDTO {
    String name;
    String street;
    public PersonDTO(String name, String street) {
        this.name = name;
        this.street = street;
    }
}

// usage
Query query = em.createNativeQuery(
    "SELECT p.name AS name, a.street AS street FROM Person p, Address a WHERE p.address_id=a.id",
    "PersonDTOMapping");
List<PersonDTO> result = query.getResultList();