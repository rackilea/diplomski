public interface RequestDTO {
    boolean validate(RequestValidation validator);
}

public class BalanceDTO implements RequestDTO {
    // ...

    @Override
    public boolean validate(RequestValidation validator) {
        return validator.validate(this);
    }
}

public class RequestValidation {
    // components...

    public boolean validate(BalanceDTO balanceDTO) {
        return true;    // todo...
    }

    public boolean validate(AnotherDTO anotherDTO) {
        return true;    // todo...
    }
}