public static void main(String[] args)
    {
        try
        {
          //First call in exception chain:
          fbc = new FBClient();
          fbc.init();
        }
        catch (Exception e)
        {
          e.printStackTrace();
          System.exit(1);
        }

    }