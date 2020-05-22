public class MyCustomProcedure extends StoredProcedure{

    public MyCustomProcedure(JdbcTemplate jdbcTemplate, String procedureName) {
      super(jdbcTemplate, procedureName);
      declareParameter(new SqlParameter("param1", Types.NUMERIC));
      declareParameter(new SqlParameter("param2", Types.ARRAY, "STRING_ARRAY"));
      declareParameter(new SqlParameter("param3", Types.ARRAY, "STRING_ARRAY"));
      declareParameter(new SqlOutParameter("return_flag", Types.NUMERIC));
    }

    public boolean execute(Long param1, String[] param2, String[] param3) {
       Boolean resultFlag= null;
       BigDecimal outputReturned  = null;
       Map resultMap = null;
       AbstractSqlTypeValue customArrayTypeParam2 = null;
       AbstractSqlTypeValue customArrayParamType3 = null;

       try (final Connection connectionWrapper = getJdbcTemplate().getDataSource().getConnection()) {
        customArrayTypeParam2 = new MyCustomOracleArrayType(connectionWrapper, param2);
        customArrayTypeParam3 = new MyCustomOracleArrayType(connectionWrapper, param3);
           resultMap = super.execute(param1, customArrayTypeParam2, customArrayTypeParam3);
         }catch(Exception e){
            e.printStackTrace();
         }

        if (MapUtils.isNotEmpty(resultMap)) {
             outputReturned = (BigDecimal) resultMap.get("return_flag");
        if ((Integer.valueOf(outputReturned.intValue())).equals(Integer.valueOf(1))) {
            resultFlag= true;
        }
    } else {
        resultFlag= false;
    }
    return resultFlag;
   }
 }