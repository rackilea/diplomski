@EventHandler
public void onPlayerJoin(PlayerJoinEvent event) {
    CraftPlayer craftPlayer = (CraftPlayer) event.getPlayer();
    //I am not actually typing this code in an IDE, so feel free to change
    //the try-catch block to only catch what is needed
    try {
        Field field = CraftHumanEntity.class.getDeclaredField("inventory");
        field.setAccessible(true);
        CraftInventoryPlayer originalInventory = (CraftInventoryPlayer) field.get(craftPlayer);
        //Store inventory here, I will use a Map that would be declared above.
        originalInventories.put(craftPlayer, originalInventory);
        field.set(craftPlayer, new CustomInventory(craftPlayer.getHandle().inventory));
    } catch (Exception e) {
        Bukkit.getLogger.log(Level.SEVERE, "Error creating custom player inventory", e);
    }
}

@EventHandler
public void onPlayerQuit(PlayerQuitEvent event) {
    CraftPlayer craftPlayer = (CraftPlayer) event.getPlayer();
    //I am not actually typing this code in an IDE, so feel free to change
    //the try-catch block to only catch what is needed
    try {
        Field field = CraftHumanEntity.class.getDeclaredField("inventory");
        field.setAccessible(true);
        CraftInventoryPlayer originalInventory = originalInventories.get(craftPlayer);
        //Store inventory here, I will use a Map that would be declared above.
        field.set(craftPlayer, originalInventory);
    } catch (Exception e) {
        Bukkit.getLogger.log(Level.SEVERE, "Error replacing player inventory with original", e);
    }
}