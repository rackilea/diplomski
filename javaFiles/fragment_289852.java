public int getBalance(int baseValue) {
    String[] cols = new String[] {
        "SUM(" + TRANSACTION_AMOUNT + ")"
    };
    try {
        Cursor data = SqlDatabase.query(DATABASE_TABLE, cols, null, null, null, null, null);
        return data.getInt(data.getColumnIndexOrThrow(cols[0])) + baseValue;
    } catch(IllegalArgumentException e) {
        Log.e("MyApp", "Couldn't get balance", e);
        return 0;
    }
}