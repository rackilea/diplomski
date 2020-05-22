Function<String, Integer> f1 = String::length;

Function<Integer, Long> f2 = i -> i * 10_000L;

Function<Long, LocalDate> f3 = LocalDate::ofEpochDay;

Function<LocalDate, Integer> f4 = LocalDate::getYear;