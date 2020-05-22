import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

...

public Optional<ProductDTO> findByRating(int rating) {
    return this.avgRating() == rating ? Optional.of(createDTO()) : Optional.empty();
}

private ProductDTO createDTO() {
    ProductDTO productDTO = new ProductDTO();
    productDTO.setProductName(productName);
    productDTO.setProductsLeftForSale(productsLeftForSale());
    productDTO.setAvgRating(avgRating());
    productDTO.setTotalVotes(reviews.size());
    return productDTO;
}

public List<ProductDTO> findProductsByRating(int rating) {
    return products.stream()
            .map(product -> product.findByRating(rating))
            .filter(Optional::isPresent)
            .map(Optional::get)
            .collect(Collectors.toList());
}