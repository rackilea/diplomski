@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="WIDGET_TYPE")
public abstract class Widget implements Serializable  {

    @Column(name="serialNumber", length=64, nullable=false, unique=true)
    private String serialNumber;
    ...