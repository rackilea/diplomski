try {

        ClassPathResource configFile = new ClassPathResource("config.json");

        String json = IOUtils.toString(configFile.getInputStream(), Charset.forName(Util.UTF_8));
    } catch (IOException e) {
        String errMsg = "unexpected error while reading config file";
        logger.error(errMsg, e);
        throw new Exception(e);
    }