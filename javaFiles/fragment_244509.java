public enum BitString {
    //...

    public static Optional<BitString> getByTransactionType(String transactionType)
    {
        return Arrays.stream(values())
            .filter(x -> x.transactionType.equals(transactionType))
            .findFirst();
    }
}