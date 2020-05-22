@Entity
public class Type {

    @Id
    @Column(name = "typeId")
    private Integer id;

    @Column(name="typeName")
    private String name;


    @OneToMany
    @JoinColumn(name="parentTypeId")
    List<MetaType> metaTypes;
}