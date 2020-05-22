List<QBTransaction> transactions = null;
try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
    transactions =
        stream.filter(w -> w.startsWith("Payment"))
              .map(l -> l.split(csvSplitBy))
              .map(t -> new QBTransaction(new TransactionDetails(
                 t[TRANSACTION_DATE],
                 t[TRANSACTION_NUM],
                 t[TRANSACTION_NAME],
                 Double.parseDouble(t[TRANSACTION_AMOUNT])
              )))
              .collect(Collectors.toList());
}
transactionServiceImpl.addAll(transactions);