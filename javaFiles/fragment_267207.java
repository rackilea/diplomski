// Get the time of a player and subtract it by one
Integer value = players.get(player) - 1;
// Update the value
players.put(player, value);

// If the time runs out, than delete the player
if (value == 0){
    players.remove(player);
}