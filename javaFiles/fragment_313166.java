Properties properties = new Properties();

        try{
            properties.load(propertiesfile.getInputStream());
        }catch(IOException e){
            logger.error("Parsing error while reading properties file",e.toString());
        }