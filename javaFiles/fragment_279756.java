if(plugin.getConfig().getBoolean("enable_global_death")) {
    String bc = Utils.chat(plugin.getConfig().getString("global_death"));
    bc = bc.replace("<killer>", killer.getName());        
    bc = bc.replace("<player>", p.getName());
    bc = bc.replace("<kill_weapon>", killer.getItemInHand().getType().toString());
    Bukkit.broadcastMessage(bc);
    return;
}