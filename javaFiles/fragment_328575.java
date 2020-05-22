public class Response {
    private Result result;
}

public class Result {
    private String account;
    private Map<String, List<Asset>> assets;
    private Map<String, List<Asset>> balances;
    private String ledger_hash;
    private String ledger_index;
    private Map<String, String> obligations;
    private String status;
    private boolean validated;
}

public class Asset {
    private String currency;
    private String value;
}