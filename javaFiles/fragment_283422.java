@XmlRootElement
@XmlSeeAlso({MessageResponse.class})
abstract class Response {
  String command;

  public Response() {
    // TODO Auto-generated constructor stub
  }

  public Response(String command) {
    this.command = command;
  }

  @XmlElement
  public String getCommand() {
    return command;
  }

  public void setCommand(String command) {
    this.command = command;
  }
}