public void handle(HttpExchange exchange)
  {
    OutputStream responseBody=exchange.getResponseBody();
    String requestMethod=exchange.getRequestMethod(),requestPath=exchange.getRequestURI().getPath(),title="Page title",root="",
           responseString="<Html>\n<Head>\n  <Title>"+title+"</Title>\n </Head>\n<Body>\n<Center>\n";
    LinkedHashMap<String,String> params=queryToMap(exchange.getRequestURI().getRawQuery());
    File file;

    try
    {
      URI uri=exchange.getRequestURI();
      if (params.get("Img")!=null) file=new File(URLDecoder.decode(params.get("Img"),"utf-8")).getCanonicalFile();
      else file=new File(root+uri.getPath()).getCanonicalFile();

      if (!file.getPath().startsWith(root))
      {
        // Suspected path traversal attack: reject with 403 error.
        responseString+="403 (Forbidden)\n";
        responseString+="\n</Center>\n</Body>\n</Html>";
        exchange.sendResponseHeaders(403,0);
        responseBody.write(responseString.getBytes());
      }
      else if (!file.isFile())
      {
        Headers responseHeaders=exchange.getResponseHeaders();
        responseHeaders.set("Content-Type","text/html;charset=utf-8");
        exchange.sendResponseHeaders(200,0);

        responseString+=Get_Content()+"<P>\n";
        // Object does not exist or is not a file: reject with 404 error.
        responseString+="\n</Center>\n</Body>\n</Html>";
        responseBody.write(responseString.getBytes());
      }
      else
      {
        // Object exists and is a file: accept with response code 200.
        exchange.sendResponseHeaders(200,0);
        FileInputStream fs=new FileInputStream(file);
        final byte[] buffer=new byte[0x10000];
        int count;
        while ((count=fs.read(buffer))>=0) responseBody.write(buffer,0,count);
        fs.close();
      }
    }
    catch (Exception e)
    {
      responseString+="<P><Pre>"+e.toString()+"</Pre>\n";
      e.printStackTrace();
    }
    finally
    {
      try
      {
        responseBody.close();
        if (Id.equals("Stop_Server")) server.stop(0);
      }
      catch (Exception ex)
      {
        ex.printStackTrace();
      }
    }
  }

  public LinkedHashMap<String,String> queryToMap(String query)                 // http://localhost:6600/Resume_App?Id=Edit&File_Name=AT&T.txt
  {
//    Out("query = "+query);
    LinkedHashMap<String,String> result=new LinkedHashMap();
    for (String param : query.split("&"))
    {
      String pair[]=param.split("=");
      if (pair.length>1) result.put(pair[0],pair[1]);
      else result.put(pair[0],"");
    }
    return result;
  }