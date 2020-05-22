public List<Comment> commentList(String statusId) {
    FacesContext context = FacesContext.getCurrentInstance();
    Query query = em.createQuery(
            "SELECT c FROM Comment c WHERE c.statusId=" + statusId,
            Comment.class);
    List<Comment> results = query.getResultList();
    return results;
}