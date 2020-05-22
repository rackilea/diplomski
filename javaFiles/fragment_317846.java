@JsonIgnoreProperties(ignoreUnknown = true)
abstract class someclass{
@JsonCreator
someclass(
@JsonProperty("type") String type,@JsonProperty("origin") Origin origin) {}
}