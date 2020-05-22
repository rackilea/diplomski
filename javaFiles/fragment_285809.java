@XmlRootElement(name = "CC5Response")
public class CC5Response {

    private String ProcReturnCode;
    private String AuthCode;
    private String OrderId;
    private String TransId;
    private String ErrMsg;
    private String Response;
    private String HostRefNum;
    private String GroupId;
    private List<Extra> Extra;   

    /**
     * @return the ProcReturnCode
    */
   @XmlElement(name="ProcReturnCode")
   public String getProcReturnCode() {
          return ProcReturnCode;
   }

  /**
   * @param ProcReturnCode the ProcReturnCode to set
  */

  public void setProcReturnCode(String ProcReturnCode) {
        this.ProcReturnCode = ProcReturnCode;
  }

   /**
   * @return the AuthCode
   */
   @XmlElement(name="AuthCode")
   public String getAuthCode() {
          return AuthCode;
   }

   /**
   * @param AuthCode the AuthCode to set
   */
  public void setAuthCode(String AuthCode) {
        this.AuthCode = AuthCode;
   }

  /**
  * @return the OrderId
  */
   @XmlElement(name="OrderId")
   public String getOrderId() {
       return OrderId;
  }

   /**
   * @param OrderId the OrderId to set
   */
   public void setOrderId(String OrderId) {
         this.OrderId = OrderId;
   }

   /**
    * @return the TransId
   */
  @XmlElement(name="TransId")
  public String getTransId() {
       return TransId;
  }

  /**
   * @param TransId the TransId to set
  */
  public void setTransId(String TransId) {
        this.TransId = TransId;
  }

  /**
   * @return the ErrMsg
  */
  @XmlElement(name="ErrMsg")
  public String getErrMsg() {
       return ErrMsg;
  }

  /**
   * @param ErrMsg the ErrMsg to set
  */
  public void setErrMsg(String ErrMsg) {
         this.ErrMsg = ErrMsg;
  } 

  /**
   * @return the Response
  */
   @XmlElement(name="Response")
   public String getResponse() {
       return Response;
   }

  /**
    * @param Response the Response to set
   */
   public void setResponse(String Response) {
       this.Response = Response;
   }

  /**
   * @return the HostRefNum
  */
 @XmlElement(name="HostRefNum")
 public String getHostRefNum() {
      return HostRefNum;
 }

 /**
  * @param HostRefNum the HostRefNum to set
 */
  public void setHostRefNum(String HostRefNum) {
        this.HostRefNum = HostRefNum;
  }

   /**
     * @return the GroupId
   */
   @XmlElement(name="GroupId")
   public String getGroupId() {
        return GroupId;
   }

  /**
   * @param GroupId the GroupId to set
   */
   public void setGroupId(String GroupId) {
        this.GroupId = GroupId;
   }

   /**
    * @return the Extra
    */
   @XmlElement(name="Extra")
   public List<Extra> getExtra() {
        return Extra;
   }

    /**
    * @param Extra the Extra to set
    */
    public void setExtra(List<Extra> Extra) {
              this.Extra = Extra;
   }
  }