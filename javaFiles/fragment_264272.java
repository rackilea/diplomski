@Entity
public class Employee {
    @Id
    @Column(name="EMP_ID")
    private long id;
    ...
    @OneToMany(mappedBy="owner")
    private List<Phone> phones;
    ...
}
@Entity
public class Phone {
    @Id
    private long id;    
    ...
    @ManyToOne
    @JoinColumn(name="OWNER_ID")
    private Employee owner;
    ...
}