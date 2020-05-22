String myKey = "foo";
ProductProjectionType projectionType = ProductProjectionType.CURRENT;

ProductProjectionQuery query =
    ProductProjectionQuery.of(projectionType)
         .withPredicates(product -> product.allVariants()
            .where(variant -> variant.key().is(myKey)));