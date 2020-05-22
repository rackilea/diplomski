DSL.using(configuration)
   .transaction(ctx -> {
       DSL.using(ctx)
          .update(TABLE)
          .set(TABLE.COL, newValue)
          .where(...)
          .execute();
   });