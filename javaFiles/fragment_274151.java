@Entity(name="EVENT")
@AttributeOverrides( { @AttributeOverride( name="id", column=@Column(name="EVENT_ID",nullable=false)),
    @AttributeOverride( name="name", column=@Column(name="EVENT_NAME",nullable=false,length =50)),
    @AttributeOverride( name="date", column=@Column(name="EVENT_DATE_UTC", nullable=false)),
    @AttributeOverride( name="dateLocal", column=@Column(name="EVENT_DATE_LOCAL", nullable=false)),
    @AttributeOverride( name="state", column=@Column(name="STATE",nullable=false)),
    @AttributeOverride( name="operator", column=@Column(name="OPERATOR")),
    @AttributeOverride( name="deviceId", column=@Column(name="DEVICE_ID",nullable=false)),
    @AttributeOverride( name="deviceType", column=@Column(name="DEVICE_TYPE")),
    @AttributeOverride( name="deviceDescription", column=@Column(name="DEVICE_DESCRIPTION")),
    @AttributeOverride( name="description", column=@Column(name="EVENT_DESCRIPTION")),
    @AttributeOverride( name="priority", column=@Column(name="PRIORITY",nullable=false)),
    @AttributeOverride( name="attachment", column=@Column(name="ATTACHMENT")),
    @AttributeOverride( name="mimeType", column=@Column(name="MIME_TYPE")),
})
public class DbClass extends GeneratedClass {

    public DbClass(GeneratedClass generatedClass) {
        this.setName(generatedClass.getName());
        this.setDateLocal(generatedClass.getDateLocal());
        ...
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Override
    public long getId() {
        return super.getId();
    }

    public void setId(long id) {
        super.setId(id);
    }