public void delete(List<String> names, Integer creatorId) {
    List<Object[]> batchArgs = new ArrayList<>();
    for (String name : names) {
        batchArgs.add(new Object[] { name, creatorId });
    }
    jdbcTemplate.batchUpdate("DELETE FROM persons WHERE person_name = ? and creator_id = ?", batchArgs);
}