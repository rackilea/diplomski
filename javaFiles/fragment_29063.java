public void validate() {
 if (customerName == null || customerName.trim().equals("")) {
   addFieldError("customerName", "Required");
 }
 // the same for email ID
}