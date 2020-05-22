@Entity
public class MyLong {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private Long long;

}