@Entity
public class SimpleEntity {
  @Id
  @GeneratedValue
  private Integer id;
  private String data1;
  @Audited
  private String data2;
  ...
}