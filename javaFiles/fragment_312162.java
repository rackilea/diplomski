import org.bukkit.plugin.java.JavaPlugin;

    public final class {$PluginName} extends JavaPlugin {
        @Override
        public void onEnable() { //This should proberbly be done onCommand rather than onEnable
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    long time = System.currentTimeMillis();
                    while (some condition....){
                        //load list of players
                        //now iterate through player list and do your code
                        //check if 10min has passed:
                        if ((System.currentTimeMillis() - time) > 600000){
                            //now break the loop and run your other code for the rest of the minigame
                            break;
                        }
                    }
                    //code for the rest of the minigame
                    while (true){
                        //load list of players
                        //now iterate through player list and do your code for the rest of the time
                    }
                }
           }); 
           thread.start();               
        }
    }