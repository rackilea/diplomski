class Plan {


  // ...

  @JsonCreator
  public Plan(byte[] bytes) {
    this(bytes, 0);
  }

  @JsonValue
  public byte[] getBytes() {
      return bytes;
  }

  // ...

}