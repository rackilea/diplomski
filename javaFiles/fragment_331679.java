public YourObject findById(Integer id) {
    return em.find(YourObject.class, id);
}
public void persist(YourObject entity) {
    em.persist(entity);
}
public void update(YourObject entity) {
    em.merge(entity);
}
public void delete(YourObject entity) {
    em.remove(entity);
}