@JsonAutoDetect(getterVisibility = Visibility.NONE)
public interface Picture {

  @JsonSerialize
  @JsonProperty("name")
  String getName();

  @JsonSerialize
  @JsonProperty("delete_url")
  String getDeleteUrl();

  //...