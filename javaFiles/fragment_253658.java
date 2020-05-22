@Entity
public class MetaType {

    @Id
    private Integer id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "typeId")
    private Type type;

    @ManyToOne
    @JoinColumn(name = "parentTypeId")
    private Type parentType;
}