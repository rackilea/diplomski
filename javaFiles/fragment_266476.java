CriteriaBuilder cb = entityManager.getCriteriaBuilder();
CriteriaQuery<Item> criteria = cb.createQuery(Item.class);
Root<Item> root = criteria.from(Item.class);
criteria.select(root);

if (null != search) {
    String pattern = "%pattern here%";
    criteria.where(cb.like(root.get("name"), pattern));
}