public class ChildId implements Serializable {
    private Long confDetail; // matches the name of the attribute
    private FatherId father;  // matches name of attribute and type of Father PK
    ...
}


@Entity
@IdClass(ChildId.class)
@Table(name = "CHILD_TABLE")
public class Father {
    @Id
    @Column(name = "CONF_DETAIL")
    private Long confDetail;

    @Id
    @JoinColumns({
        @JoinColumn(name="CONF_ID", referencedColumnName="CONF_ID"),
        @JoinColumn(name="CONF_TYPE", referencedColumnName="CONF_TYPE")
    })
    @ManyToOne
    Father father;
}