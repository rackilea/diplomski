public PointsValidityPeriod findCurrent()
{
    TypedQuery<PointsValidityPeriod> validityPeriodQuery = entityManager.createNamedQuery(PointsValidityPeriod.FindCurrent, PointsValidityPeriod.class);

    return validityPeriodQuery.getSingleResult();
}