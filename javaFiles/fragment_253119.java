try {   
    ...
    List<A> as = q.getResultList();
    result = as.get(as.size() - 1);
catch (NoResultException e) {
    // doo something
}