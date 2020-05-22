@Projection(name = "totalAmount", types = Loan.class)
public interface LoanTotalAmount {

    @Value("#{target}")
    Loan getLoan();

    @Value("#{@loanRepo.getTotalAmountByLoan(target)}")    
    Double getAmount();
}