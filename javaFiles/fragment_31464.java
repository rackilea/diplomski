public interface TaxScheme {
    public Currency applyTax(Currency beforeTax);
}

public class TenPercentTax implements TaxScheme {
    public Currency applyTax(Currency beforeTax) {
        return beforeTax.times(1.10);
    }
} 

public Currency computeTotal(List<Product> products, TaxScheme taxScheme) {
    Currency beforeTax = computeBeforeTax(products);
    Currency afterTax = taxScheme.applyTax(beforeTax);
    return afterTax;
}