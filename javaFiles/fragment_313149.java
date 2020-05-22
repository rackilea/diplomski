private static MazeMain instance;

 // Does not need override
 public void onEnable(){
     PluginManager manager = Bukkit.getPluginManager();
     manager.registerEvents(new EventHandle(), this);

     // Make the instance of this class available for other classes
     instance = this;

     // Your config generator

     // You don't need to log enabling and disabling
     // ^(Bukkit does that automatically)

 }

 public void onDisable(){
     instance = null;
 }

 public static MazeMain getInstance(){
     return instance;
 }