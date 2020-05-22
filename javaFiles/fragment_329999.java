@Entity
public class Entity1 {
    @EmbeddedId
    private ParentId identifier;

    @OneToOne(mappedBy="relationToEntity1")
    private Entity2 relationToEntity2;

    //Left out the getters and setters for simplicity
}

@Entity
public class Entity2 {
    @EmbeddedId private Entity2Identifier id;
    //Left out the getters and setters for simplicity.

    @MapsId("parentId")
    @OneToOne
    private Entity1 parent;

}

@Embedabble
public class Entity2Identifier {
    private String firstPartOfIdentifier;
    private ParentId parentId;
    //Left out the getters and setters for simplicity.
}