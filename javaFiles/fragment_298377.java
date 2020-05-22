@Entity
@Table(name = "nametable")
public class NameObjectimplements Serializable{
    private UUID  id;
    private String firstName;
    .
        .
        . 
     //   etc...



    public NameObject() {

    }


    @Id
    @Column(name = "ID")
**@org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")**
    public UUID  getId() {
        return id;
    }
    @Column(name = "`firstName`")
    public String getFirstName() {
        return firstName;
    }



//   setter method....