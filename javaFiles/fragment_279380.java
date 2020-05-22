Map<EligibilityRequest, List<String>> res = 
        requests.stream()
        .collect(Collectors.groupingBy(Function.identity(),
                 Collectors.mapping(
                        EligibilityRequest::getProductCodes,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                            .flatMap(List::stream)
                                            .collect(Collectors.toList())))
                        )
                );