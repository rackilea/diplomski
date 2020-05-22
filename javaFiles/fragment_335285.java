// Entity class
@Entity
@IdClass(ExternalMatchPK.class)
@Table(name = "external_match")
public class ExternalMatch {

    @Id
    @Column(name = "place_id")
    private Integer placeId;

    @Id
    @Column(name = "external_object_id")
    private Integer externalObjectId;

    // ... Other stuff here

}


// Key class
public class ExternalMatchPK implements Serializable {
    private Integer placeId;
    private Integer externalObjectId;
}


// Related entity class
@Entity
@Table(name = "external_object")
public class ExternalObject extends AbstractNameableEntity {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "external_object_id", nullable = false)
    private List<ExternalMatch> matches;

    // ...
}