Optional<Long> maxId = trdObj.getAccount().getSubAccounts.stream()
        .max(Comparator.comparing(SubAccount::getSubAccountId))
        .map(SubAccount::getSubAccountId);

if (maxId.isPresent()) {
    // ...
}