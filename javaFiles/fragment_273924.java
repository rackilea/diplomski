LootChest chest = Game.getLootChest(); // i'm making these up
Armor armor = chest.getArmor();

Player player = Game.getCurrentPlayer();
if (armor != null && player.accepts()) {
    player.equipArmor(armor);
}