private Map<String,String> prepareParameters(MultivaluedMap<String, String> queryParameters) {

   Map<String,String> parameters = new HashMap<String,String>();

   Iterator<String> it = queryParameters.keySet().iterator();


         while(it.hasNext()){
           String theKey = (String)it.next();
           parameters.put(theKey,queryParameters.getFirst(theKey));
       }

   return parameters;

    }