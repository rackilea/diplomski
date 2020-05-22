@Entity
@Table(name = "entity1")
class Entity1 extends AbstractEntity<EntityData1>{
  @OneToMany(mappedBy = "Entity1")
  private Set<EntityData1> data;

  public Set<EntityData1> getData()
  { return data; }
}