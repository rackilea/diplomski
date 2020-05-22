public void setDrawResult(BigInteger id, List<BigInteger> ballNumbers, List<BigInteger> ballsWithMegaBall, Date drawDates,BigInteger megaPlier){

    String sql = "INSERT INTO draw_result (id, ball_numbers,  balls_with_mega_ball, draw_dates, mega_plier) VALUES(?, ?, ?, ?, ?)";
    jdbcTemplate.update(sql
            , id
            , createSqlArray(ballNumbers)
            , createSqlArray(ballsWithMegaBall)
            , drawDates
            , megaPlier
    );
}

private java.sql.Array createSqlArray(List<BigInteger> list){
    java.sql.Array intArray = null;
    try {
        intArray = jdbcTemplate.getDataSource().getConnection().createArrayOf("bigint", list.toArray());
    } catch (SQLException ignore) {
    }
    return intArray;
}