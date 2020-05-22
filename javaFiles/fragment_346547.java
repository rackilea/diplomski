public static void main(String[] args) {
        List<DomainCustomerZoneDtls> domainCustomerZoneDtls = Arrays.asList(
                new DomainCustomerZoneDtls("abc", 1),
                new DomainCustomerZoneDtls("abc", 2),
                new DomainCustomerZoneDtls("abc", 3),
                new DomainCustomerZoneDtls("efg", 1),
                new DomainCustomerZoneDtls("efg", 2)
        );

    Map<Integer, List<String>> integerListMap = buildZoneIdDomainMap(domainCustomerZoneDtls);

    System.out.println(integerListMap);
}

private static Map<Integer, List<String>> buildZoneIdDomainMap(List<DomainCustomerZoneDtls> domainCustomerZoneDtls) {
    return domainCustomerZoneDtls.stream()
            .collect(Collectors.groupingBy(DomainCustomerZoneDtls::getCustomerZoneId,
                    Collector.of(
                            ArrayList::new,
                            (strings, domainCustomerZoneDtls1) -> strings.add(domainCustomerZoneDtls1.getDomain()),
                            (strings, strings2) -> {
                                strings.addAll(strings2);
                                return strings;
                            }
                    )));
}