create.select(DSL.field("table_name"))
      .from("tables t")
      .where("t.table_schema LIKE '" + schemaName + "'")
      .limit(DSL.inline(10))
      .offset(DSL.inline(2))
      .getSQL();