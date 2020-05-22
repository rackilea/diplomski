@Embeddable
public class ItemAssociationId implements Serializable {
  @Column(nullable = false, updatable = false)
  private Long itemId;
  @Column(nullable = false, updatable = false)
  private Long groupId;
  @Column(nullable = false, updatable = false)
  private String type;
}