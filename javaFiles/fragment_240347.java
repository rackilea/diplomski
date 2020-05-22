@JsonCreator
  public B(@JsonProperty(value = "a", required = true) String a,
           @JsonProperty(value = "b", required = true) String b,
) {
    super(a);
    this.b = b;
  }