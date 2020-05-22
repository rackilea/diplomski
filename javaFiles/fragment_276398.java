<T> Map<String, List<T>> getUserPerCompany(final Function<User, T> converter) {
    return getUserStream().collect(Collectors.toMap(
            c -> c.getName(),
            c -> c.getUsers()
                  .stream()
                  .map(converter)
                  .collect(Collectors.toList())
    ));
}