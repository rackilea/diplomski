Person p = new PersonPojo();
p.setId(10);

PersonRecord record = new PersonRecord();
record.from(p); // Reuse pre-existing reflection functionality here.

Condition condition = DSL.trueCondition();
for (Field<?> field : record.fields())
    if (record.getValue(field) != null)
        condition = condition.and(((Field) field).eq(record.getValue(field)));

create.selectFrom(Tables.PERSON).where(condition).fetch();