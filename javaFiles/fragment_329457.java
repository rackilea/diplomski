public class MapItemSqlParameterSourceProvider implements
        ItemSqlParameterSourceProvider<Map<String, Object>> {

    public SqlParameterSource createSqlParameterSource(Map<String, Object> item) {
        return new MapSqlParameterSource(item);
    }

}