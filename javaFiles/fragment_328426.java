private Map<String,String> prepareParameters(MultivaluedMap<String, String> queryParameters) {

   Map<String,String> parameters = new HashMap<String,String>();

   for(String str : queryParameters.keySet()){
     parameters.put(str, queryParameters.getFirst(str));
   }
   return parameters;

    }