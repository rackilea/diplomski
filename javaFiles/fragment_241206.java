protected List<Pair<String, Double>> extractPlannedMaterials(List<ProductionDataSummaryDTO> productionData) {
    Map<String, Double> result = new HashMap<>();

    productionData.stream()
        .map(ProductionDataSummaryDTO::getDailyProductionDatas)
        .flatMap(Set::stream)
        .forEach(dailyData -> {
            String partNumber = dailyData.getProduct().getPartNumber();
            double sum = dailyData.getLineDatas().stream().mapToDouble(LineDataDTO::getPlannedQuantity).sum();

            result.compute(partNumber, (key, value) -> value == null ? sum : value + sum));
        }

    // return result as is or transform to list of pairs
}