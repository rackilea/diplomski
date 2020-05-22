public abstract class JavaPlugin{
    Server server;
    public ServerManager getServer(){
        return new ServerManager(server);
    }

    public ServerManager setServer(Server s){
        server = s;
    }

    public PluginLogger getLogger(){
        return new PluginLogger(server);
    }

    public abstract void onEnable();
}