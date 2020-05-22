@Entity
@Table(name = "user")
@org.hibernate.annotations.Entity(
        dynamicInsert = true, dynamicUpdate=true
)
public class User implements java.io.Serializable {
 // your properties
}