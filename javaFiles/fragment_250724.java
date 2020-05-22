public class Database{
    private String _sqlString;
    private Map<Integer,Object> _parameters;

    public Database(String sql){
        _sqlstring = sql;
    }

    public void setParameters(Map<Integer,Object> param){
        _parameters = param;
    }

    /* 
     * I'm assuming you already have a method like this
     */
    public List processQuery(){
        List results = new ArrayList();
        /* 
         * establish connection here
         */
        PreparedStatement preparedStatement = connection.prepareStatement(this._sqlString);

        if(_parameters != null){
            /* 
             * Iterate over the map to set parameters 
             */
            for(Integer key : _parameters.keySet()){
                preparedStatement.setObject(key, _parameters.get(key));
            }
        }            

        ResultSet rs = preparedStatement.executeQuery();
        /*
         * process the ResultSet
         */
        return results;
    }

}