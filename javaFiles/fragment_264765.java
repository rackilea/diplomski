public void logIt() {
    String sql = "SELECT * FROM player_card " +
            "WHERE email " +
            "In (SELECT email FROM player_card As Tmp " +
            "   WHERE card = player_card.card " +
            "   GROUP BY email, card " +
            "   HAVING COUNT(*) > 1) " +
            "   ORDER BY email;";
    Cursor csr = mDB.rawQuery(sql,null);
    Log.d("RESULT","Number of rows extracted = " + String.valueOf(csr.getCount()));
    csr.close();