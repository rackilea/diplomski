@Entity
@SQLInsert( sql="INSERT INTO Demo(name, id) VALUES(?,?)")
@Loader(namedQuery = "betterLoad")
@NamedNativeQuery(name="betterLoad",
        query="select id, name from Demo where id= ?",
        resultClass = Demo.class)
public class Demo {
    @Id
    private Long id;
    private String name;
}