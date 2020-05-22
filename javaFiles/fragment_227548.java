String home = System.getenv("APPDATA");
    if (StringUtils.isEmpty(home)) {
        home = System.getProperty("user.home");
    }
    CONFIG_HOME = new File(home, ".myProgram").getAbsoluteFile();
    CONFIG_HOME.mkdirs();