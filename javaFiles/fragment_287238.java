@Entity
@Table(name = "A")
@NamedQuery(
    name="A.findAllByCategoryId"
    query="SELECT a FROM A a "
        + "INNER JOIN a.categoryList relACat "
        + "INNER JOIN relACate.category c"
        + "WHERE c.id = :categoryId"
)
public class A{
    // cf. above
}