for (Product p : productList) {
    if (p.getId().equals(productId)) {
        return p;
    }
}
return null;