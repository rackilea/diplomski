Long timestamp = 0L;
try {
    timestamp = Long.parseLong(transactionData[2]);
} catch (NumberFormatException e) {
    return;
}