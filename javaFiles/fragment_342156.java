List<SellProductAmountDTO> sellProductAmountDTOList = new ArrayList<>(); // this should be full
List<SellContractProduct> sellContractProductList = new ArrayList<>(); // this should be full

// build a stream on array 2 to use in the for loop
Stream<SellContractProduct> SellContractProductListStream = sellContractProductList.stream();

for(SellProductAmountDTO sellProductAmountDTO : sellProductAmountDTOList) {
    // find the correct SellContractProduct
    Optional<SellContractProduct> productOption = SellContractProductListStream
            .filter(sellContactProduct -> sellContactProduct.getId().equals(sellProductAmountDTO.getSellContractId()))
            .findFirst();

    // if the SellContractProduct was found, then set its values into the sellProductAmountDTO's order product
    if(productOption.isPresent()) {
        sellProductAmountDTO.getOrderProduct().setProductId(productOption.get().getId());
        sellProductAmountDTO.getOrderProduct().setCostGroupId(productOption.get().getCostGroupIds());
    }
}