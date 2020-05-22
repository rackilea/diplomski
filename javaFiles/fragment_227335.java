import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;

public class MyBot {
    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration.Builder()
        .setName("PircBotX") //Set the nick of the bot. CHANGE IN YOUR CODE
        .setLogin("LQ") //login part of hostmask, eg name:login@host
        .setAutoNickChange(true) //Automatically change nick when the current one is in use
        .setCapEnabled(true) //Enable CAP features
        .setServerHostname("irc.freenode.net")
        .addAutoJoinChannel("#pircbotx") //Join the official #pircbotx channel
        .buildConfiguration();
        PircBotX bot = new PircBotX(configuration);

        //Connect to server
        try {
            //bot.connect();
            bot.startBot();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}