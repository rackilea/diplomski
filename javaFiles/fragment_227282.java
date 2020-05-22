@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerSegmentRequest {

   @JsonAlias({"cust_lpid", "LPID" })
   String cust_lpid;

   @JsonAlias({"cust_uid", "UserId" })
   String cust_uid;

   public String getCust_lpid() {
      return cust_lpid;
   }

   public void setCust_lpid(String cust_lpid) {
      this.cust_lpid = cust_lpid;
   }

    public String getCust_uid() {
      return cust_uid;
   }

    public void setCust_uid(String cust_uid) {
       this.cust_uid = cust_uid;
   }
}