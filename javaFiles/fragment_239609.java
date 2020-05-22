for (DoubleStack ds : items.values()) {
    int random = new Random().nextInt(100);    
    int chance = ds.getChance(); // Must be in percentage
    if (random < chance) {
        p.getInventory().addItem(ds.getItemStack());
        break;
    }
}