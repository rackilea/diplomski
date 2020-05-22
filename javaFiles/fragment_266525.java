@Embeddable
public class MoneyWrapper {


    @Columns(columns = { @Column(name = "total_currency", length=10), @Column(name = "total") })
    @Type(type = "org.jadira.usertype.moneyandcurrency.joda.PersistentMoneyAmountAndCurrency")
    Money totalmoney;


    @Column(name = "total",updateable=false,insterable=false);
    BigDecimal total to agregate;

    @Column(name = "total_currency",updateable=false,insterable=false);
    BigDecimal totalCurrency;  
}