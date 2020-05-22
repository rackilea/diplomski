Comparator<IProduct> comparator = (p1, p2) -> {
    Integer v1 = p1 != null ? p1.getProvidedProductData() : null;
    Integer v2 = p2 != null ? p2.getProvidedProductData() : null;

    if (v1 == null ^ v2 == null)
        return v1 != null ? 1 : -1;

    return v1 != null ? v1.compareTo(v2) : 0;
};