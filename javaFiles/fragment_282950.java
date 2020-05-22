public class Calculator {

    public BigDecimal balance(Installment installment) {
        return installment.getPrincipalDue().subtract(installment.getPenaltyPaid())
                .add(installment.getInterestDue()).subtract(installment.getInterestPaid())
                .add(installment.getFeeDue()).subtract(installment.getFeePaid())
                .add(installment.getPenaltyDue()).subtract(installment.getPenaltyPaid());
    }
}