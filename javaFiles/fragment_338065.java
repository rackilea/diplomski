public void execute() {
    Player player = playerSupplier.get();
    player.setName(name);
    player.setWarMode(warMode);
    playerList.add(player);
}