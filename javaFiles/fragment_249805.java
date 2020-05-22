class Product {

  private String id;
  private String vendor;

  @JsonDeserialize(using = InnerSetDeserializer.class)
  private Set<Image> images;

  // getters, setters
}