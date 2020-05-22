mport java.util.Map;

public class CardDetailsDTO {

    private Map<String,String> debitCardDetails;

    private Map<String,String> creditCardDetails;

    public Map<String,String> getCreditCardDetails() {
        return creditCardDetails;
    }

    public void setCreditCardDetails(Map<String,String> creditCardDetails) {
        this.creditCardDetails = creditCardDetails;
    }

    public Map<String,String> getDebitCardDetails() {
        return debitCardDetails;
    }

    public void setDebitCardDetails(Map<String,String> debitCardDetails) {
        this.debitCardDetails = debitCardDetails;
    }


}