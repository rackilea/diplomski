trdObj.getAccount().getSubAccounts.stream()
        .max(Comparator.comparing(SubAccount::getSubAccountId))
        .map(SubAccount::getSubAccountId)
        .ifPresent(maxId -> {
            // ...
        });