public Optional<Account> getAccount(String accountUuid) throws ApiException {
    try {
        return apiClient.accountList().stream()
            .filter(account -> account.getUuid().equals(accountUuid))
            .findAny();
    } catch (ApiException e) {
        /* Log exception */
        return Optional.empty();
    }
}