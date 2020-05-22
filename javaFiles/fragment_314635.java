public Page<Post> returnPosts(PageRequest pageRequest) {
    Page<T> page = null;
    try {

        String queryStr = "Your Query";
        Query query = entityManager.createNativeQuery(queryStr, Post.class);
        query.setFirstResult((pageRequest.getpageNumber()) * pageRequest.getPageSize());
        query.setMaxResults(pageSize);
        List<Post> posts= query.getResultList();
        page = new PageImpl<>(posts, pageRequest, 0);
    }catch(Exception ex){
        ex.printStackTrace();
    }
    return page;
}