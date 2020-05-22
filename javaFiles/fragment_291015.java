Field<Date> d = LOG.CREATED_DATE.cast(SQLDataType.DATE);

jooq.select(count(), d)
    .from(LOG)
    .groupBy(d)
    .orderBy(d)
    .fetch();