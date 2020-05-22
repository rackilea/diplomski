accounts.stream()
        .filter(account -> account.getMargin() >= MARGIN_LIMIT)
        .sorted(Comparator.comparingDouble(Account::getMargin)
                          .reversed()
                          .thenComparing(Comparator.comparing(Account::getName)))
        .skip(PAGE_SIZE * (page - 1))
        .limit(PAGE_SIZE)
        .collect(Collectors.toMap(
              Account::getMargin,
              x -> {
                 List<Account> list = new ArrayList<>();
                 list.add(x);
                 return list;
              },
              (left, right) -> {
                  left.addAll(right);
                  return left;
              },
              LinkedHashMap::new));