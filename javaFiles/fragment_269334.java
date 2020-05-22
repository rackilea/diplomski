public class CarpetCostEstimator {
   double price = -1.0;
   String postCode = "XXX-XXX";
   double labourCharge = 1.0;

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }

   public String getPostCode() {
      return postCode;
   }

   public void setPostCode(String postCode) {
      this.postCode = postCode;
   }

   public double getLabourCharge() {
      return labourCharge;
   }

   public void setLabourCharge(double labourCharge) {
      this.labourCharge = labourCharge;
   }
}