enum TransactionStatus
{
    ENABLED, NOT_ENABLED, NOT_SUPPORTED
}

TransactionStatus status = BitString.getBygetByTransactionType(transaction.transactionType)
    .map(bitString -> featureMaps.get(bitString))
    .map(enabled -> enabled ? TransactionStatus.ENABLED : TransactionStatus.NOT_ENABLED)
    .orElse(TransactionStatus.NOT_SUPPORTED);