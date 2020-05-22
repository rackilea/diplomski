Result<Record1<Timestamp>> result = createQueryBuilder()
    .selectDistinct(trunc(incomeTable.REF_DATE, DatePart.DAY).as("refdate"))
    .from(incomeTable)
    .where(incomeTable.PROBOS_ID.eq(probosId))
    .orderBy(field(name("refdate"))
    .fetch();