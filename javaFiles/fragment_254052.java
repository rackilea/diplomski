public List<VacationRequest> getVacationsInPeriodForUser(Long userId,
        Date startDate, Date endDate) {
    List<VacationRequest> requests = getSessionFactory()
        .getCurrentSession()
        .createQuery(
                "select req from VacationRequest req left join fetch req.vacationType where req.requestState.description = 'APPROVED' and req.user.id= ? and req.startDate <= ? and req.endDate >= ?")
        .setParameter(0, userId).setParameter(1, enDate)
        .setParameter(2, startDate).list();

return requests;
}