class Content {
  @OneToMany
  @JoinColum(name = "item_id")
  @Where("item_type = 'CONTENT'")
  Set<Comment> comments;
}

class Product {
  @OneToMany
  @JoinColum(name = "item_id")
  @Where("item_type = 'PRODUCT'")
  Set<Comment> comments;
}

class Comment {
  @Id
  @GeneratedValue
  Long id;
  @Enumerated(STRING)
  ItemType itemType;
  Lont itemId;
}

enum ItemType {
  CONTENT,
  PRODUCT
}