@Table(
    name="a", 
    uniqueConstraints={
        @UniqueConstraint(columnNames={"b_id", "token"})
    }
)
@Entity
public class A implements Serializable {
    // ...
}