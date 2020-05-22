@Entity
@Table(name="RealEstateDFl")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {...})
public class GrnEntity {

    //...
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "grn", column = @Column(name = "grn_main")),
            @AttributeOverride(name = "calendarDate", column = @Column(name = "grn_date_main"))
    })
    protected GrnType grnType;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "grn", column = @Column(name = "grn_sec")),
            @AttributeOverride(name = "calendarDate", column = @Column(name = "grn_date_sec"))
    })
    protected GrnType grnTypeSecondary;

    //...
}