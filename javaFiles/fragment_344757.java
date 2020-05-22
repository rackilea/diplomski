jooq.insertInto(PERSON)
    .columns(PERSON.ID, PERSON.FNAME, PERSON.LNAME)
    .select(select(val(452452), PERSON.FNAME, PERSON.LNAME)
           .from(PERSON)
           .where(PERSON.ID.eq(1)))
    .execute();