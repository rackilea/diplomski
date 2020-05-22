// Entity class
@Entity
@IdClass(ExternalMatchPK.class)
@Table(name = "external_match")
public class ExternalMatch {

    @Id
    @ManyToOne
    @JoinColumn(name = "external_object_id", referencedColumnName = "id")
    private ExternalObject externalObject;

    @Id
    @ManyToOne
    @JoinColumn(name = "place_id")
    private Poi place;

    // ... Other stuff here

}


// Key class
public class ExternalMatchPK implements Serializable {
    private Poi place;
    private ExternalObject externalObject;
}


// Related entity class
@Entity
@Table(name = "external_object")
public class ExternalObject extends AbstractNameableEntity {


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "externalObject")
    private List<ExternalMatch> matches;

    // ...
}