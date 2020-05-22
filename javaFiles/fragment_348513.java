public class Associate {

  private String associateName;
  private String workStatus;

  public Associate() {
    // This constructor is optional, a no-args constructor is added by the compiler to any class not explicitly naming a constructor.
  }

  public String getAssociateName() {
    return associateName;
  }

  public void setAssociateName(String associateName) {
    this.associateName = associateName;
  }  

  public String getWorkStatus() {
    return workStatus;
  }

  public void setWorkStatus(String workStatus) {
    this.workStatus = workStatus;
  }  

  public int tracksAssociateStatus() {
    // TODO write logic here
    return 1; // TODO change to whatever you need to return
  }
}