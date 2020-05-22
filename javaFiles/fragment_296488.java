@Override
public void addProduct(Product product) {

    MultipartFile proudctImage = product.getProudctImage();

    if (!proudctImage.isEmpty()) {
        try {
            proudctImage.transferTo(resourceLoader.getResource("resources/images/"+product.getProductId()+".png").getFile());

        } catch (Exception e) {
            throw new RuntimeException("Product Image saving failed", e);
        }
    }

    listOfProducts.add(product);
}