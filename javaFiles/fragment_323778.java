public void callProc(ParamHolder[] paramHolders){

try (Connection con = createConnWithDbDetails(getDBDetails());
             CallableStatement stmnt =
             con.prepareCall("{ call custom(?,?) }")) {
            //Create a arrayDescriptor
            ArrayDescriptor descriptor =
                ArrayDescriptor.createDescriptor("PARAM_HOLDER_OBJ_TABLE", con);
            Array array = new ARRAY(descriptor , con, paramHolders);
            stmnt.setArray(1, array );
            stmnt.registerOutParameter(2,OracleType.VARCHAR,"p_out_var");           //Register any output variable if your procedure returns any thing.
            stmmnt.execute();                                              //this will take the Array of ParamHolder straight to the DB for processing.
            String result = stmnt.getString(2);                                  //Will fetch yuou the result form the DB to your local String.
          }Catch(Exception e){
              e.printStackTrace();
          }
}