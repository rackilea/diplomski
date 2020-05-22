List<SellProductAmountDTO> sellProductAmountDTOList = new ArrayList<>(); // this should be full
List<SellContractProduct> sellContractProductList = new ArrayList<>(); // this should be full

// make a map listing contracts by their Id
Map<Long, SellContractProduct> SellContractProductMap = sellContractProductList.stream()
        .collect(Collectors.toMap(SellContractProduct::getId, Function.identity()));

for(SellProductAmountDTO sellProductAmountDTO : sellProductAmountDTOList) {
    // find the correct SellContractProduct in the map
    SellContractProduct product = SellContractProductMap.get(sellProductAmountDTO.getSellContractId());

    if(product != null) {
        sellProductAmountDTO.getOrderProduct().setProductId(product.getId());
        sellProductAmountDTO.getOrderProduct().setCostGroupId(product.getCostGroupIds());
    }
}