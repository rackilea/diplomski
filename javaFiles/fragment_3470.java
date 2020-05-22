@Entity
public class Party {

  @Id
  private BigInteger partyID;

  private String name;

  @OneToMany(mappedBy="party")
  private Set<Address> addresses;

} 

@Entity
public class Organization extends Party {} 

@Entity
public class Person extends Party {} 

@Entity
public class Agency extends Organization {} 

@Entity
public class Agent extends Person {}

@Entity
public class Address{

  @Id
  private BigInteger addressID;

  @ManyToOne
  private Party party;

  private String street;
}