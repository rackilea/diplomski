public class DB_Get_Values {

  public String P_Key = "";
  public String Mac_addr = "";
  public String SDK_VRS = "";

 public DB_Get_Values( String P_Key, String Mac_addr, String SDK_VRS) 
  {
    this.P_Key = P_Key;
    this.Mac_addr = Mac_addr;
    this.SDK_VRS = SDK_VRS;
 }
  public String get_Mac_addr() {
    return Mac_addr;
  }
  public String get_P_Key() {
    return P_Key;
  }
  public String get_SDK_VRS() {
        return SDK_VRS;
      }
}