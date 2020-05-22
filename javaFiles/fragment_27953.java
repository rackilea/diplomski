Field<Integer> num = DSL.field("@row_number:=@row_number +1", Integer.class);
DSLContext create = DSL.using(connection, dialect);
create.configuration().set(new InitialisingVariableListener());
create.select(AUTHOR.FIRST_NAME, AUTHOR.LAST_NAME, num)
      .from(AUTHOR)
      .limit(5)
      .fetch();