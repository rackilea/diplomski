Supplier<Person> supplyMaxUpdateDatePerson = () -> personList.stream()
        .max(Comparator.comparing(Person::getUpdateDate))
        .orElse(null); // or an identity value equivalent for 'Person'

Person maxAccountUpdateDateOrElseUpdateDate = personList.stream()
        .flatMap(person -> person.getAccounts().stream()
                .map(account -> new AbstractMap.SimpleEntry<>(person, account.getAccountUpdateDate())))
        .filter(entry -> entry.getValue() != null) // otherwise you would always have a result in max
        .max(Comparator.comparing(AbstractMap.SimpleEntry::getValue))
        .map(AbstractMap.SimpleEntry::getKey)
        .orElseGet(supplyMaxUpdateDatePerson); // invoked only when all 'accountUpdateDate' are 'null'