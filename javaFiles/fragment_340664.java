@Entity
@Table(name = "entitya")
public class EntityA {

  @Id
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private Long name;

  @OneToOne
  private MasterChild master;

  @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
  private Set<EntityB> childEntities;

}