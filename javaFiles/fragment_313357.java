String[] kits = getConfig().getString("Kits." + args[0] + ".Items").split(",");
String[] itemNames = getConfig().getString("Kits." + args[0] + ".names").split(",");

for (int i = 0; i < kits.length; i++) {

    String[] singleKits = kits[i].split("-");

    ItemStack kit = new ItemStack(Integer.valueOf(singleKits[0]), Integer.valueOf(singleKits[1]));
    ItemMeta kitDisplayName = kit.getItemMeta();

    kitDisplayName.setDisplayName(itemNames[i]);
    kit.setItemMeta(kitDisplayName);
}