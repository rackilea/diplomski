InputStream inputStream = null;

        try
        {
            inputStream = new BufferedInputStream(new FileInputStream("config.properties"));
            Properties properties = new Properties(); 

            properties.load(new InputStreamReader(inputStream, "UTF-8")); // load all properties in config.properties file
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
        finally
        {
            inputStream.close();
        }