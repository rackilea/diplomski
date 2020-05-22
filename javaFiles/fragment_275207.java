Source s = SOURCE.as("s");
Field<String> I = SOURCE.ID.as("I");
TableLike<?> e = create.select()
        .from(SOURCE)
        .where(SOURCE.NAME.isNotNull())
        .asTable().as("e");

create.selectCount()
      .from(s)
      .join(e)
      .on(s.NAME.equal(e.field(I)))
      .fetchOne().value1();