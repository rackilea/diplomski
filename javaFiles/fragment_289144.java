package your.package.here;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.dthielke.herochat.ChannelChatEvent;
import com.dthielke.herochat.ChannelManager;
import com.dthielke.herochat.Herochat;
import your.package.here.MyPlugin;

public class MyPluginPlayerListener implements Listener {

    private MyPlugin plugin;

    public MyPluginPlayerListener(MyPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerChat(ChannelChatEvent event) {
        ChannelManager cm = Herochat.getChannelManager();
        String newFormat;
        Player player = event.getSender().getPlayer();
        String chatTitle = plugin.titlesConfig.getTitle(player);

        if (!chatTitle.equalsIgnoreCase("")) {
            chatTitle = "[" + chatTitle + "]";
        }
        if (event.getFormat().equalsIgnoreCase("{default}")) {
            newFormat = cm.getStandardFormat();
            newFormat = newFormat.replaceAll("\\{title\\}", chatTitle");
        } else {
            newFormat = event.getFormat();
            newFormat = newFormat.replaceAll("\\{title\\", chatTitle");
        }

        event.setFormat(newFormat);
    }
}