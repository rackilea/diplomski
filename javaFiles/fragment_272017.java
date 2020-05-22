class Chargeback {
      private double amount;
      private String currency;

      // Getter Methods
    //  @JsonIgnore
      public double getAmount() {
        return amount;
      }

    //  @JsonInclude(Include.NON_NULL)
      public String getCurrency() {
        return currency;
      }

      // Setter Methods

      public void setAmount(double cb_amount) {
        this.amount = cb_amount;
      }

      public void setCurrency(String currency) {
        this.currency = currency;
      }
    }

    public class Order {
      private double amount;
      Chargeback ChargebackObject;

      public double getAmount() {
        return amount;
      }

      public void setAmount(double amount) {
        this.amount = amount;
      }

      public Chargeback getChargebackObject() {
        return ChargebackObject;
      }

      public void setChargebackObject(Chargeback chargebackObject) {
        ChargebackObject = chargebackObject;
      }
    }