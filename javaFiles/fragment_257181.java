public class OnPlayerDeath implements Listener {

// Make new HashMap
private Map<Player, Integer> livesMap = new HashMap<>();

@EventHandler
public void OnDeath(PlayerDeathEvent event){
    Player player = event.getEntity().getPlayer();

    int lives;

    if(!livesMap.containsKey(player)) {
        // Set the default amount of lives to 2. (3 minus 1, since the player already died once)
        lives = 2;
    } else {
        // Subtract one from the player's lives
        lives = livesMap.get(player) - 1;  
    }

    if (!(player.getKiller() instanceof Player)) {
        player.sendMessage("Died by a something else. You have " + lives + " lives left.");
    } else {
        player.sendMessage("Died by a human. You have " + lives + " lives left.");
    }

    // Update new life count
    livesMap.put(player, lives);
}