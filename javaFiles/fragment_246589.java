// This t reference now has all the column references like the original table
TestSafesFundsAllocation t = TEST_SAFES_FUNDS_ALLOCATION.as("t");

// The subquery is also named "t", but has a different definition
Table<?> subquery = table(
    select(
        TEST_SAFES_FUNDS_ALLOCATION.LEDGER_ID,       
        sum(TEST_SAFES_FUNDS_ALLOCATION.AMOUNT)
           .as(TEST_SAFES_FUNDS_ALLOCATION.AMOUNT))
   .from(TEST_SAFES_FUNDS_ALLOCATION)
   .groupBy(TEST_SAFES_FUNDS_ALLOCATION.LEDGER_ID)).as(t);

// Now, select again from the subquery, but dereference columns from the aliased table t
context.select()
       .from(subquery)
       .where(t.AMOUNT.greaterOrEqual(amount))
       .and(t.LEDGER_ID.notIn(excludedLedgers))
       .orderBy(t.AMOUNT.asc())
       .limit(1)
       .fetchOne();