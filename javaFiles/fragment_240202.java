static final Attribute<User, String> PRODUCT_NAMES_ORDERED = new MultiValueAttribute<User, String>() {
    public Iterable<String> getValues(User user, QueryOptions queryOptions) {
        return user.orders.stream()
                .map(order -> order.products).flatMap(Collection::stream)
                .map(product -> product.name)::iterator;
    }
};