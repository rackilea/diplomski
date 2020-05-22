@Entity @IdClass(PersonId.class)
public class Person {
    @Id int ssn;
    @Id String nationality;
     ....
}