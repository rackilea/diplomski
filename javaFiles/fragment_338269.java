Field<Timestamp> refdate = trunc(incomeTable.REF_DATE, DatePart.DAY).as("refdate");

Result<Record1<Timestamp>> result = createQueryBuilder()
    .selectDistinct(refdate)
    .from(incomeTable)
    .where(incomeTable.PROBOS_ID.eq(probosId))
    .orderBy(refdate)
    .fetch();