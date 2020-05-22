List<Address> addresses = Optional.ofNullable(users)
            .orElseGet(Collections::emptyList)
            .stream()
            .filter(Objects::nonNull)
            .flatMap(x -> x.getAddress().stream())
            .collect(Collectors.toList());