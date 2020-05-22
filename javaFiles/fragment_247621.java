Map<String, String> saArgs = new HashMap<String, String>();
saArgs.put("jnlp.serverip", System.getProperty("jnlp.serverip"));
saArgs.put("jnlp.serverport", System.getProperty("jnlp.serverport"));
saArgs.put("port", "8887");
saArgs.put("surfaceip", "192.168.0.50");

ProcessBuilder rmLauncher = new ProcessBuilder().command(fullCmdString.stream().toArray(String[]::new));
    Process p;

    for (Map.Entry<String, String> entry : args.entrySet())
    {
        rmLauncher.environment().put(entry.getKey(), entry.getValue());
    }

    try
    {
        p = rmLauncher.start();
     }
    catch (Exception e)
    {
        logger.fatal("Failed to launch " + appName + ": " + e);
        System.exit(1);
    }