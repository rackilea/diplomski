@Entity
@Table(name = "entityb")
public class EntityB {

  @Id
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @ManyToOne
  @JoinColumn(name = "parent")
  private EntityA parent;

}