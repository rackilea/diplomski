public final class JSONChangeSet {
  private final String comment;
  private final Resource owner;

  @JsonCreator
  public JSONChangeSet(
    @JsonProperty("comment") final Resource owner,
    @JsonProperty("comment") final String comment
  ) {
    this.comment = comment;
    this.owner = owner;
  }

  public String getComment() {
    return comment;
  }
}