@PersistenceContext
public EntityManager em;
...
List<Tag> ltags = new ArrayList<Tag>();
ltags.add(tagOne);
ltags.add(tagTwo);
List<?> list = em.createNamedQuery("Post.selectPostsByTags")
                                                    .setParameter("tags", ltags)
                                                    .getResultList();

for (Object object : list) {
    System.out.println("Results: "+object);
}