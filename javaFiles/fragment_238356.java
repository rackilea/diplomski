package test;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.mysql.jdbc.Connection;

public class Event extends JavaPlugin implements Listener {

    // Mysql update data
    public static ConcurrentHashMap<UUID, Integer> player_zombiekills = new ConcurrentHashMap<UUID, Integer>();

    // Mysql connection data
    public static Connection connection;
    private String host = "localhost";
    private String database = "DB";
    private String username = "user";
    private String password = "123";
    private int port = 3306;

    //Kill zombie event
    @EventHandler
    public void zombieDeath(EntityDeathEvent eve) {
        if (!(eve.getEntity() instanceof Zombie)) return; // Stop if death is not zombie
        if (!(eve.getEntity().getKiller() instanceof Player)) return; // Stop if killer is not player
        UUID uid = eve.getEntity().getKiller().getUniqueId(); // Save player uuid
        if (player_zombiekills.contains(uid)) player_zombiekills.put(uid, 0); // Set kills 0 if not exist in hashmap
        player_zombiekills.put(uid, player_zombiekills.get(uid) + 1); // plus 1 kills value
    }

    //On enable connection
    public void onEnable() {
        try {
            if (connection != null && !connection.isClosed()) return;
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
            if (!connection.isClosed()) System.out.println("[MySQL] " + "Connected to '" + database + "'");
        } catch (Exception e) {
            System.err.println("[MySQL] " + e.getMessage());
        }

        new BukkitRunnable() {
            public void run() {
                // for updates
                for (Entry<UUID, Integer> ent : player_zombiekills.entrySet()) {
                    try {
                        // send update
                        connection.createStatement().executeUpdate("UPDATE `tablename` SET `zombiekills`=`zombiekills`+" + ent.getValue() + " WHERE `uuid`='" + ent.getKey().toString() + "'");
                        // Sucess remove entry from hashmap to reset kills
                        player_zombiekills.remove(ent.getKey());
                    } catch (SQLException e) { // If error
                        System.err.println("[MySQL] " + e.getMessage()); // Print error in console
                    }
                }
            }
        }.runTaskTimerAsynchronously(this, 20, 20 * 60 * 10); // Run async loop every 10 minutes
    }
}