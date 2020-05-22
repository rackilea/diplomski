Code Snippet:
//variable declaration
//ParamHolder[] paramHolders = ..getTheParamHolderArray();
        try (Connection con = createConnWithDbDetails(getDBDetails());
             CallableStatement stmnt =
             con.prepareCall("{ call custom(?) }")) {
            //Create a arrayDescriptor
            ArrayDescriptor descriptor =
                ArrayDescriptor.createDescriptor("PARAM_HOLDER_OBJ_TABLE", con);
            Array array = new ARRAY(descriptor , con, paramHolders);
            stmnt.setArray(1, array );
          }Catch(Exception e){
              e.printStackTrace();
          }