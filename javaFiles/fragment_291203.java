Person p = new PersonPojo();
p.setId(10);

PersonRecord record = new PersonRecord();
record.from(p); // Reuse pre-existing reflection functionality here.

create.selectFrom(Tables.PERSON).where(DSL.condition(record)).fetch();