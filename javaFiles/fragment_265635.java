public List<Applicant> getApplicants() {
    TypedQuery<Applicant> query = em.createQuery(
        "select a.id, a.name from Applicant a",
        Applicant.class
    );
    return query.getResultList();
}