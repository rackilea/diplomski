@Override
public void onEnable(){
    if (r.getCnfg().getBoolean("Chat.DeathmessagesListenerDisable") == false) {
        Bukkit.getPluginManager().disablePlugin(this);
        return;
    } 
}