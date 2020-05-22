CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery<Tuple> cq = cb.createTupleQuery();
Root<ObjectMetadata> root = cq.from(ObjectMetadata.class);
cq.multiselect(
    root.get("fileName").alias("filename"), 
    cb.greatest(root.<Date>get("lastModified").alias("lastmodified")
);
cq.groupBy(root.get("fileName"));

List<Tuple> result = em.createQuery(cq).getResultList()
for (Tuple t: result) {
    System.out.println(t.get("filename") + " " + t.get("lastmodified"));
}