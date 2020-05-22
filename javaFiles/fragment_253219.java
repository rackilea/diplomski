accounts.stream()
        .filter(account -> account.getMargin() >= MARGIN_LIMIT)
        .skip(PAGE_SIZE * (page - 1))
        .limit(PAGE_SIZE)
        .collect(Collectors.groupingBy(
               Account::getMargin,
               () -> new TreeMap<Double, List<Account>>(Comparator.reverseOrder()),
               Collectors.toList()));