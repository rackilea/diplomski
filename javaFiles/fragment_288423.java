@Override
public Product save(Product product, String brandName) {

    Brand brand = brandService.findByBrand(brandName);
    if (brand == null) {
        brand = brandService.save(brandName);
    }
    return productRepository.save(product);

}