@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Response<T> {

  @XmlElement
  protected String status;

  @XmlElement
  protected Wrapper<T> result;

  ...

  public Response(String status, List<T> result) {
    this.status = status;
    this.result = new Wrapper<>(result);
  }

  ...

  public List<T> getResult() {
    return result.getItems();
  }

  ...
}