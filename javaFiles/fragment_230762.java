Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        logger.setLevel(Level.INFO);
        try {
            FileHandler fileTxt = new FileHandler("/root/apache-ofbiz/applications/party/webapp/partymgr/test.txt",true);

            SimpleFormatter formatterTxt = new SimpleFormatter();
            fileTxt.setFormatter(formatterTxt);
            logger.addHandler(fileTxt);

            logger.log(Level.INFO,"this is first line in file");

    } catch (SecurityException e) {
    } catch (IOException e) {
    }