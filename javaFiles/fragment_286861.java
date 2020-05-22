public List<Product> findProductsBy(List<Category> categories) {
    List<Long> categoryIds = new ArrayList<Long>();
    for(Category category:categories){
        categoryIds.add(category.getId());
    }
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Product> query = cb.createQuery(Product.class);
    Root product = query.from(Product.class);
    Predicate predicateCategory = product.get("categoryId").in(categoryIds);

    query.select(product).where(predicateCategory);
    return em.createQuery(query).getResultList();