@Entity
public class ItemAssociation {
  @EmbeddedId
  private ItemAssociationId id;
  @Column
  private String value;
  @JoinColumn(name = "itemId", insertable = false, updatable = false)
  private Item item;
  @JoinColumn(name = "groupId", insertable = false, updatable = false)
  private Group group;
}