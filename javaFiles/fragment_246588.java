// Create a local variable to contain your subquery. Ideally, provide an explicit alias
Table<?> t = table(
    select(
        TEST_SAFES_FUNDS_ALLOCATION.LEDGER_ID,       
        sum(TEST_SAFES_FUNDS_ALLOCATION.AMOUNT)
           .as(TEST_SAFES_FUNDS_ALLOCATION.AMOUNT))
   .from(TEST_SAFES_FUNDS_ALLOCATION)
   .groupBy(TEST_SAFES_FUNDS_ALLOCATION.LEDGER_ID)).as("t");

// Now, use t everywhere, instead of TEST_SAFES_FUNDS_ALLOCATION
context.select()
       .from(t)
       .where(t.field(TEST_SAFES_FUNDS_ALLOCATION.AMOUNT).greaterOrEqual(amount))
       .and(t.field(TEST_SAFES_FUNDS_ALLOCATION.LEDGER_ID).notIn(excludedLedgers))
       .orderBy(t.field(TEST_SAFES_FUNDS_ALLOCATION.AMOUNT).asc())
       .limit(1)
       .fetchOne();