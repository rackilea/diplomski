while (cursor1.moveToNext()) {
    catTotal = 0;
    curCat = cursor1.getString(cursor1.getColumnIndexOrThrow(
                     CategoriesDbContract.TblCategories.COLUMN_NAME_CATEGORY));
    cursor2 = db.query(...);

    while (cursor2.moveToNext()) {
        catTotal += cursor2.getDouble(cursor2.getColumnIndexOrThrow(
                        TransactionsDbContract.TblTransactions.COLUMN_NAME_AMOUNT));
    }
}