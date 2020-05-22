Map<RiskItemDTO, List<RiskItem> itemsByRisk = repo.findRiskItemsByRiskTypeName(riskTypeName)
        .stream()
        .map(mapper::mapToDTO)
        .collect(groupingBy(RiskItemDTO::getRisk));

List<RiskWithRiskItemsDTO> list = itemsByRisk.entrySet().stream()
        .map( entry -> new RiskWithRiskItemsDTO(entry.getKey(),entry.getValue()))
        .collect(Collectors.toList());