public List<Action> findAllActions() {
    final String selectStatement = "SELECT id,name FROM Actions"; // or your query
    try {

        return jdbcTemplate.query(selectStatement, getActionRowMapper());

    } catch (EmptyResultDataAccessException e) {
        LOGGER.error("Get all actions - empty set", e);
        return Collections.emptyList();
    }
}
private RowMapper<Action> getActionRowMapper() {
    return (resultSet, rowNum) -> {

        int actionId = resultSet.getInt("id");
        String actionName = resultSet.getString("name");

        return action;
    };
}