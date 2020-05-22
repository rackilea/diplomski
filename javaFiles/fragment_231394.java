@Entity
public class BasicTestEntity {
  @Id @GeneratedValue private Integer id;
  private String name;
}

public class BasicTestEntityDao 
    extends GenericDaoImpl<BasicTestEntity, Integer> {
}