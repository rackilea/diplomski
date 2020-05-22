public int compare(Collection c1, Collection c2)
{
    int n;
    n = c1.id.compareTo(c2.id);
    if (n != 0) return n;
    n = c1.entityType.compareTo(c2.entityType);
    if (n != 0) return n;
    n = c1.brandId.compareTo(c2.brandId);
    if (n != 0) return n;
    return c1.productId.compareTo(c2.productId);
}