interface ProductRepository
          extends CrudRepository<Product, Long>
                  , QueryDslPredicateExecutor<Product> {
  default Iterable<Product> findAllByAttributes(final Map<String, String> attributes) {
    final QProduct root = QProduct.product;
    BooleanExpression query = root.isNotNull();

    for (final String attribute : attributes.keySet()) {
      final QProductAttribute branch = root.attributes.any();
      final BooleanExpression subquery = branch.attribute.name.equalsIgnoreCase(attribute)
                                                          .and(branch.value.equalsIgnoreCase(attributes.get(attribute)));

      query = query.and(JPAExpressions.selectFrom(QProductAttribute.productAttribute).where(subquery).exists());
    }

    return findAll(query);
  }
}