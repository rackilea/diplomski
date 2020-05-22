class A{
  @JsonView(VerboseViewA.Minimal.class)
  String field1;
  @JsonView(VerboseViewA.Complete.class)
  String field2;
  @JsonView(VerboseViewA.Complete.class)
  Collection<B> bEntities;
 }

 class B{
    @JsonView({VerboseViewA.Complete.class,VerboseViewB.Minimal.class})
    String field2;
    @JsonView(VerboseViewB.Complete.class)
    String field3;
 }