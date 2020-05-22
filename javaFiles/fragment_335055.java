public List<Action> findAllActions() {
    final String selectStatement = "SELECT id,name FROM Actions"; // or your query
    try {

        return jdbcTemplate.query(selectStatement,(resultSet, rowNum) -> {

            int actionId = resultSet.getInt("id");
            String actionName = resultSet.getString("name");

            Action action = new Action();
            action.setId(actionId);
            action.setName(actionName);

            return action;
        });

    } catch (EmptyResultDataAccessException e) {
        LOGGER.error("Get all actions - empty set", e);
        return Collections.emptyList();
    }
}