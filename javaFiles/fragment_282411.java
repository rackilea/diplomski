// This is the "weakly typed", generic record with the additional columns
Record record =
DSL.using(configuration)
   .select(...)
   .from(ACCOUNT_BILL_FEE)
   .fetchOne();

// This is one way to transform the above record into a
// "table-typed" record that you can store
AccountBillFeeRecord r1 = record.into(ACCOUNT_BILL_FEE);
r1.update();