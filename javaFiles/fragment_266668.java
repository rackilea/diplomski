@Entity
@Table(uniqueConstraints=
           @UniqueConstraint(columnNames = {"username"})) 
public class Registration {
    //...
}