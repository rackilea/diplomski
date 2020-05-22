//Change
MainProgram MainCode = new MainProgram();
//to
MainProgram MainCode;

public EventListeners(MainProgram plugin) {
    //Add this
    this.MainCode = plugin;
    plugin.getServer().getPluginManager().registerEvents(this, plugin);
}