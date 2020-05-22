public interface Information {
    public String getResponseAsString();
}

public interface AccountInformation extends Information {
    public List<String> getAccountInformation();
}

public interface BalanceInformation extends Information {
    public List<String> getBalanceInformation();
}