try {
    Query q = entityManager.createQuery("from LearningUnit unit order by unit.id desc");
    q.setMaxResults(1);
    LearningUnit unit = (LearningUnit) q.getSingleResult();
    // we found a LearningUnit
    // ...
} catch (NoResultException e) {
    // We didn't find any LearningUnit
    // ...
}