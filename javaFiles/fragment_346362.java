public ProductToDisplay getProductClear(long productID, long languageID,
                                     long deviceID) throws Exception {
    Product product =
            productRepository.findById(productID).orElseThrow(()-> new Exception(
                    "There is no such product"));

    Language language = languageRepository.findById(languageID).orElseThrow(()-> new Exception(
            "There is no such language"));
    ProductInfo prodInfo = productInfoRepository.findByProductAndLanguage(product, language)
            .orElseThrow(()-> new Exception(
            "There is no such product info"));

    Device device =  deviceRepository.findById(deviceID).orElseThrow(()-> new Exception(
            "There is no such image"));
    ProductImage prodImg = productImageRepository.findByProductAndDevice(product, device)
            .orElseThrow(()-> new Exception(
            "There is no such product Image"));

    return new ProductToDisplay(product,
            prodInfo.getDescription(), prodImg.getImage());
}