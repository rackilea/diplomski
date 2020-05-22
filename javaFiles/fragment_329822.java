public class ElasticsearchLog {

  @JestId
  private String _id;
  @SerializedName("@version")
  private String version;
  @SerializedName("@timestamp")
  private String timestamp;
  private String type;

  @Override
  public String toString() {
  return "ElasticsearchLog{" +
  "_id='" + _id + '\'' +
  ", version='" + version + '\'' +
  ", timestamp='" + timestamp + '\'' +
  ", type='" + type + '\''
  ' }';

}