public List<User> dobRangeSearch(Date dateOfBirthSearch1, Date dateOfBirthSearch2) {
    Query q = em.createQuery("SELECT u FROM USERS U WHERE u.DATEOFBIRTH BETWEEN :date1 and :date2)
      .setParameter("date1", dateOfBirthSearch1)
      .setParameter("date2", dateOfBirthSearch2;
    return q.getResultList();

}