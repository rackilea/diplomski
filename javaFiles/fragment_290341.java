@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GetReturnAnalysis", namespace = "http://www.address.com/integration")
public class GetReturnAnalysisRequest {
  @XmlElement(name = "entityCode", namespace = "http://www.address.com/integration")
  protected String entityCode;

  public GetReturnAnalysisRequest(String entityCode) {
    this.entityCode = entityCode;
  }

  public GetReturnAnalysisRequest() { }

  public String getEntityCode() {
    return entityCode;
  }

  public void setEntityCode(String entityCode) {
    this.entityCode = entityCode;
  }   
}