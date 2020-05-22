public class QueryDescriptionById extends SqlQuery implements IQueryDescriptionById {

RowMapper<Map<BigInteger, Status>> mapper = new RowMapperDescription();

public QueryDescriptionById(DataSource dataSource) {
    super(dataSource, SQL);
}

public Multimap<BigInteger, SmsStatus> query(Set<BigInteger> ids) {

    Map<String, Set> paramMap = Collections.singletonMap("ID", ids);
    NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(getJdbcTemplate().getDataSource());

    return template.query(SQL, paramMap, resultSet -> {
        int rowNum = 0;
        Multimap<BigInteger, Status> multimap = ArrayListMultimap.create();
        while (resultSet.next()) {
            mapper.mapRow(resultSet, rowNum++).forEach(multimap::put);
        }
        return multimap;
    });
}
.........
.........
.........
}