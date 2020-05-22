public String TesteHandleException(String url)
    {
     try {
     return Teste(url)
     } catch (Exception ex)
     {
      // Handle Exception
      return "Exception occured";
     }
    }

    public String Teste(String url) throws Exception
    {
     String[] args = new String[1];
     args[0] = url;
     return main(args);
    }