import java.math.BigDecimal;

@Value
public class Installment {
    private BigDecimal principalDue;
    private BigDecimal principalPaid;
    private BigDecimal interestDue;
    private BigDecimal interestPaid;
    private BigDecimal feeDue;
    private BigDecimal feePaid;
    private BigDecimal penaltyDue;
    private BigDecimal penaltyPaid;
}