@Entity
class Person {
   @Id 
   @GeneratedValue
   int id;

   String name;

   @OneToOne 
   @MapsId
   Address address;
}

@Entity
class Address {
    @Id
    int id;
}