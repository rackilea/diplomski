int random = new Random().nextInt(100); 
int counter = 0;   
for (DoubleStack ds : items.values()) {
    int chance = ds.getChance();
    if (random < (chance + counter) && random >= counter) {
        p.getInventory().addItem(ds.getItemStack());
        break;
    }
    counter+=chance;
}