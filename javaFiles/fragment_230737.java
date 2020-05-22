private void applyOrderBy(CriteriaBuilder criteriaBuilder, Root<Record> recordRoot, CriteriaQuery<Record> criteriaQuery) {
    //In the class code
    //private static final Date MIN_DATE = new Date(0L);
    final Date MIN_DATE = new Date(0L);

    //We treat records will NULL dateTimeField as if it was MIN_DATE.
    Order dateTimeDescOrder = criteriaBuilder.desc(
            //NULL values - last - WORKAROUND.
            criteriaBuilder.coalesce(recordRoot.get(RecordTable.FIELD_DATE_TIME), MIN_DATE));
    criteriaQuery.orderBy(dateTimeDescOrder);
}