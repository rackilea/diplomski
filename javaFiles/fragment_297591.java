DSL.using(configuration)
   .transaction(new TransactionRunnable() {
       @Override
       public void run(Configuration ctx) {
           DSL.using(ctx)
              .update(TABLE)
              .set(TABLE.COL, newValue)
              .where(...)
              .execute();
       }
   });