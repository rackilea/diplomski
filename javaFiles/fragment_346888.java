public LinkedHashMap<String,String> queryToMap(String query)
  {
    LinkedHashMap<String,String> result=new LinkedHashMap();
    for (String param : query.split("&"))
    {
      String pair[]=param.split("=");
      if (pair.length>1) result.put(pair[0],pair[1]);
      else result.put(pair[0],"");
    }
    return result;
  }