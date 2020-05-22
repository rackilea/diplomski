menuPriceByDayService
    .findAllOrderByUpdateDate(menu, DateUtils.semestralDate(), 26)
    .stream()
    .map(cp -> cp.getUpdateLocalDate())
    .distinct()
    .sorted()
    .forEach(System.out::println);