import java.io.IOException;

import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;

public class goFile {

    private static final String OAUTH = "MYOAUTHHERE";
    private static final String ADDRESS = "irc.twitch.tv.";
    private static final int PORT = 6667;
    private static final String Nick = "MYNICKHERE";
    private static final String Channel = "#MYCHANNELHERE";

    public static void main(String[] args) throws NickAlreadyInUseException, IOException, IrcException {

        TwitchBot bot = new TwitchBot(Nick);
        bot.setVerbose(true);

        bot.connect(ADDRESS, PORT, OAUTH);
        bot.joinChannel(Channel);
        bot.sendMessage(Channel, "Hello, I am a bot");
    }
}