@JsonIdentityInfo(generator = 
ObjectIdGenerators.IntSequenceGenerator.class, property = "id")

class B {
  private long id;
  private A a;
  @JsonUnwrapped
  private C c1;
  @JsonUnwrapped
  private C c2;

  // Getters, setters...
}