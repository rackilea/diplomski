public List<Game> getGamesByDate(Date day) throws SQLException {

    final DateTime startDate = new DateTime(day).withTimeAtStartOfDay();

    ....

}