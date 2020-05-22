MyTableRecord record = ...;
DSL.using(configuration)
   .update(MY_TABLE)
   .set(record)
   .where(MY_TABLE.NAME.eq(record.getName())
   .execute();