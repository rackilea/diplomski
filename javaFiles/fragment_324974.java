public class RequestValidation {
    BalanceRequestValidation balanceRequestValidation;
    AnotherRequestValidation anotherRequestValidation;

    public boolean validate(BalanceDTO balanceDTO) {
        return balanceRequestValidation.validate(balanceDTO, a, b, c);
    }

    public boolean validate(AnotherDTO anotherDTO) {
        return anotherRequestValidation.validate(anotherDTO, x, y, z);
    }
}