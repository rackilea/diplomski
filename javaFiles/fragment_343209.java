Set<String> currencyValues = currencies.getCurrencies().values()
        .stream()
        .map(CurrencyEntity::getNameOfSymbol)
        .collect(Collectors.toSet());

Set<String> requestCurrencyCodes = globalPricingRequests.stream()
        .map(GlobalPricingRequest::getCurrencyISOCode)
        .collect(Collectors.toSet());