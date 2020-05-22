@Entity
class Employee {
     :
    @OneToOne(orphanRemoval=true)
    private Address address;
     :
}