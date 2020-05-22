create.selectFrom(Tables.PERSON)
      .where(Stream.of(record.fields())
                   .filter(f -> record.getValue(f) != null)
                   .reduce(
                        DSL.trueCondition(),
                        (c, f) -> c.and(((Field) f).eq(record.getValue(f))),
                        (c1, c2) -> c1.and(c2)
                   ))
      .fetch();