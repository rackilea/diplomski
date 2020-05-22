public void onEnable() {
    getServer().getPluginManager().registerEvents(this, this);

    ItemStack result = new ItemStack(Material.COBBLESTONE, 1);
    ItemMeta meta = result.getItemMeta();
    meta.setDisplayName("Compressed Cobblestone");
    meta.setLore(Arrays.asList("9x Cobblestone"));
    result.setItemMeta(meta);

    //This recipe creates the problem that one can turn 9 compressed blocks into only one
    ShapedRecipe shaped = new ShapedRecipe(result);
    shaped.shape("@@@", "@@@", "@@@");
    shaped.setIngredient('@', Material.COBBLESTONE);

    //This recipe creates the problem that we can turn a regular cobblestone into 9
    ItemStack nine = new ItemStack(Material.COBBLESTONE, 9);
    ShapelessRecipe shapeless = new ShapelessRecipe(nine);
    shapeless.addIngredient(Material.COBBLESTONE);

    Bukkit.getServer().addRecipe(shaped);
    Bukkit.getServer().addRecipe(shapeless);
}

@EventHandler
public void onPrepareCraft(PrepareItemCraftEvent event) {
    ItemStack[] slots = event.getInventory().getMatrix();

    //The item list will only contain real itemstacks
    List<ItemStack> items = new ArrayList<ItemStack>();
    for (ItemStack slot : slots) {
        if (slot != null && slot.getType() != Material.AIR) { //We filter out air slots and null items
            items.add(slot);
        }
    }

    boolean canCraft = false;
    if (items.size() == 1) { //If we are dealing with a single item
        ItemStack item = items.get(0); //Get the first item
        if (item.getType() == Material.COBBLESTONE && item.hasItemMeta()) { //If this block is cobblestone and has metadata
            ItemMeta meta = item.getItemMeta();
            //Check if the metadata contains a display name and lore
            //If so, compare them with what they should be
            if (meta.hasDisplayName() && meta.hasLore() && meta.getDisplayName().equals("Compressed Cobblestone") && meta.getLore().toString().equals(Arrays.asList("9x Cobblestone").toString())) {
                canCraft = true;
            }
        }
    } else if (items.size() == 9) { //If we are dealing with 9 items
        boolean allCobblestone = true; //We need to check whether they are all cobblestone, otherwise we would interfere with other recipes that use all 9 slots
        for (ItemStack item : items) {
            if (item.getType() != Material.COBBLESTONE) {
                //If we find a non-cobblestone block, exit loop and let the player craft whatever he is trying to make
                allCobblestone = false;
                canCraft = true;
                break;
            }
        }
        if (allCobblestone) { //If we have 9 cobblestones in the matrix make sure none of them have metadata
            canCraft = true;
            for (ItemStack item : items) {
                if (item.hasItemMeta()) {
                    canCraft = false;
                    break;
                }
            }
        }
    }

    if (!canCraft) {
        event.getInventory().setResult(null);
    }
}