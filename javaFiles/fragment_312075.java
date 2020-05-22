Select<?> query =
DSL.using(configuration)
   .select(TABLE.A, TABLE.B)
   .from(TABLE)
   .where(TABLE.C.eq(1));

String sql = query.getSQL();
List<Object> bindvalues = query.getBindValues();