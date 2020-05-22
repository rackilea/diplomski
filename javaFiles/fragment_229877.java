long timeleft = StaticMaps.muteMap.get(uuid).getTime() * 1000; //seconds to miliseconds
long lastCheckedTime = System.currentTimeMillis();
if (System.currentTimeMillis() >= timeleft + lastCheckedTime) {
    plugin.mutemanager.destructPlayerMute(uuid, "Expired", "Removed by Console, Expired!");

} else {
    KTools.notify("debug");
    e.setCancelled(true);
}