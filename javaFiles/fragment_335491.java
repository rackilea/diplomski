@Entity
@Access(AccessType.FIELD)
public class SimpleEntity implements Serializable {
private static final long serialVersionUID = 1L;

@Id
private long id;

@Transient
private String otherName;

public long getId() {
    return id;
}

public void setId(long id) {
    this.id = id;
}

@Basic
@Column(name="name")
@Access(AccessType.PROPERTY)
public String getOtherName() {
    System.out.println("getOtherName: " + otherName);
    return otherName;
}

public void setOtherName(String otherName) {
    System.out.println("setOtherName: " + otherName);
    this.otherName = otherName;
}
}