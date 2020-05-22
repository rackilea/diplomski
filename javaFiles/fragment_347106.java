class MultipleGeneralFinancialInstitutionTransfer {
 private List<String> messageData; 

 /** constructor... */

 public Date getValueDate() {
  return parseDate(messageData.get(1)); // imagine parse date being a method to parse the actual format  
 }
}