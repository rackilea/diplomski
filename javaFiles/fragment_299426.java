public int compare(Collection c1, Collection c2)
{
    return new CompareToBuilder()
            .append(c1.id, c2.id)
            .append(c1.entityType, c2.entityType)
            .append(c1.brandId, c2.brandId)
            .append(c1.productId, c2.productId)
            .toComparison();
}