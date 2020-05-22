public class Main extends JavaPlugin {

   Storage myStorage = null;

   public void onEnable() {
       final FileConfiguration config = this.getConfig();

       config.options().copyDefaults(true);
       saveConfig();
       myStorage = new Storage(this);
   }