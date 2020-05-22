@RequestScoped
public class RequestDataHolder {
  private String tenantId;

  public String getTenantId() {
    return this.tenantId;
  }

  public void setTenantId(String tenantId) {
    this.tenantId = tenantId;
  }
}