//Initial assignment
        loadData load = null;
        System.out.println("logger is a null?: " + LOGGER);
        LOGGER.info("load: "+load);
        try
        {

            load = new loadData(); //Here the constructor calls 3 functions and exception occurs in one of those functions.
            LOGGER.info("load init: "+load);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally
        {
            LOGGER.info("finally load: "+load);
            try
            {
                LOGGER.info("finally connection: " + load.dbConnection);
                if(load.dbConnection!=null)
                {
                    load.dbConnection.close();
                    LOGGER.info("Connection closed successfully");
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }