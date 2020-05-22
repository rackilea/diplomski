public void setParameters(HttpParameters parameters) {
         Map<String, Parameter> newParams = new HashMap<String,Parameter>();
         for(String key :parameters.keySet()){
             Parameter p = parameters.get(key);
             if(p instanceof Parameter.Request){
                 newParams.put(key, new Parameter.Request(key, new String[] {"new"+p.getValue()}));
             }
         }
         parameters.appendAll(newParams);
     }