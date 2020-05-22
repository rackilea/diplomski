public class JavaInterestService<Account> implements InterestService<Account> {
    @Override
    public Kleisli<Either, Account, Option<BigDecimal>> computeInterest() {
        throw new NotImplementedException();
    }

    @Override
    public Kleisli<Either, Option<BigDecimal>, BigDecimal> computeTax() {
        throw new NotImplementedException();
    }
}