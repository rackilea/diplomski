public class Client {
   private String clientNo;
   private String clientName;

   public Client(String clientNo, String clientName) {
      this.clientNo = clientNo;
      this.clientName = clientName;
   }

   public String getClientNo() {
      return clientNo;
   }

   public void setClientNo(String clientNo) {
      this.clientNo = clientNo;
   }

   public String getClientName() {
      return clientName;
   }

   public void setClientName(String clientName) {
      this.clientName = clientName;
   }

   @Override
   public String toString() {
      return "Client [clientNo=" + clientNo + ", clientName=" + clientName
            + "]";
   }

}