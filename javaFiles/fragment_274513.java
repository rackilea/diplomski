public class PairSqlParameterSourceFactory implements SqlParameterSourceFactory {


    public SqlParameterSource createParameterSource(Object input) {
        Message<Request> message = (Message<Request>) input;
        List<Pair<String, Object>> pairs = message.getPayload().getParameters();
        MapSqlParameterSource source = new MapSqlParameterSource();
        for (Pair<String, Object> pair : pairs) { 
            source.addValue(pair.getName(), pair.getValue());
        }
        return source;
    }

}