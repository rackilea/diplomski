@Id
  private long parentId;

  // ...

  @MapsId("parentId")
  @ManyToOne
  @JoinColumn(name = "parent_id", referencedColumnName = "id", nullable = false)
  private Parent parent;