public class SneakerSpecifications {
    public static Specification<Sneaker> sizeIn(Optional<List<BigDecimal>> sizes) {
        return (root, query, builder) -> 
            sizes.isPresent() ? 
            root.get("size").in(sizes.get()) :
            builder.conjunction(); // to ignore this clause
    }

    public static Specification<Sneaker> brandIn(Optional<List<BrandType>> brands) {
        return (root, query, builder) -> 
            brands.isPresent() ? 
            root.get("brand").in(brands.get()) :
            builder.conjunction(); // to ignore this clause
    }
}