@Entity @Table(name = "Article")
public class Article {

    @Any(metaColumn = @Column(name = "user_type"))
    @AnyMetaDef(
            idType = "integer",
            metaType = "string",
            metaValues = {
                    @MetaValue(value = "A", targetEntity = UserA.class),
                    @MetaValue(value = "B", targetEntity = UserB.class)
            }
    )
    @JoinColumn(name = "user_id")
    private User user;

    ...
}