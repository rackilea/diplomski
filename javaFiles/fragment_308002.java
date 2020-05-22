try
    {
        URL baseUrl = JavaApplication2.class.getProtectionDomain().getCodeSource().getLocation();
        String myPath = (new File(baseUrl.toURI())).getCanonicalPath();
        System.out.println("Path is " + myPath);
    }
    catch (IOException ex)
    {
       // Deal with exception 
    }
    catch (URISyntaxException ex)
    {
       // Deal with exception 
    }