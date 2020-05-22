for (Map.Entry<String,String> entry : params.entrySet())
    {
      paramName=entry.getKey().replace("+"," ");
      try { paramValue=URLDecoder.decode(entry.getValue(),"utf-8"); }
      catch (Exception e) { e.printStackTrace(); }
    }