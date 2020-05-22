public void onEnable() {
    commands = new Commands();
    getServer().getPluginManager().registerEvents(new MainHandler(), this);
    getCommand(commands.cmd1).setExecutor(commands);
    getCommand(commands.cmd2).setExecutor(commands);
    getCommand(commands.cmd3).setExecutor(commands);