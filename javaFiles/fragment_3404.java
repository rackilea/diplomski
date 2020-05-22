public class MyClass {
    private double taxes;

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    public String getTaxAmount(double total){

        total*=(taxes/100);

        return currency.format(total);
    }

    public String getFinalPrice(int quantity, double beforeTax){

        double afterPrice = (beforeTax * quantity) * (1+taxes/100);

        return currency.format(afterPrice);
    }
}