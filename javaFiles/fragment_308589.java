long matches = list.stream()
                   .filter("test"::equalsIgnoreCase)
                   .collect(Collectors.counting());
for (long i = 0; i < matches; i++) {
    list.add("pass");
}