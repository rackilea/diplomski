Map<EligibilityRequest, List<List<String>>> result = 
      requests.stream()
              .collect(groupingBy(request -> request,
                    Collectors.mapping(request -> request.getProductsCode(), 
                                       toList())
                ));