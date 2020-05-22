Optional.ofNullable(DSL.using(configuration)
    .selectFrom(PRODUCT_SPACE_TABLE_NAME)
    .where(field(GTIN, Long.class).eq(gtin))
    .fetchAny()
).map(x -> {
    ProductSpace result = new ProductSpace();
    result.setCreatedAt(myConversionFunction(x.get(PRODUCT_SPACE_TABLE_NAME.CREATED_AT)))
    ...
    return result;
});