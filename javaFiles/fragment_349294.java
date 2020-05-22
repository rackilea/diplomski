import java.util.*;
import java.io.*;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.util.StringUtils;

public class JabberSmackAPI implements MessageListener {

private XMPPConnection connection;
private final String mHost = "yourserver.com"; // server IP address or the
                                                // host

public void login(String userName, String password) throws XMPPException {
    String service = StringUtils.parseServer(userName);
    String user_name = StringUtils.parseName(userName);

    ConnectionConfiguration config = new ConnectionConfiguration(mHost,
            5222, service);

    config.setSendPresence(true);
    config.setDebuggerEnabled(false);

    connection = new XMPPConnection(config);
    connection.connect();
    connection.login(user_name, password);
}

public void sendMessage(String message, String to) throws XMPPException {
    Chat chat = connection.getChatManager().createChat(to, this);
    chat.sendMessage(message);
}

public void displayBuddyList() {
    Roster roster = connection.getRoster();
    Collection<RosterEntry> entries = roster.getEntries();

    System.out.println("\n\n" + entries.size() + " buddy(ies):");
    for (RosterEntry r : entries) {
        System.out.println(r.getUser());
    }
}

public void disconnect() {
    connection.disconnect();
}

public void processMessage(Chat chat, Message message) {
    System.out.println("Received something: " + message.getBody());
    if (message.getType() == Message.Type.chat)
        System.out.println(chat.getParticipant() + " says: "
                + message.getBody());
}

public static void main(String args[]) throws XMPPException, IOException {
    // declare variables
    JabberSmackAPI c = new JabberSmackAPI();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String msg;

    // turn on the enhanced debugger
    XMPPConnection.DEBUG_ENABLED = true;

    // Enter your login information here
    System.out.println("-----");
    System.out.println("Login information:");

    System.out.print("username: ");
    String login_username = br.readLine();

    System.out.print("password: ");
    String login_pass = br.readLine();

    c.login(login_username, login_pass);

    c.displayBuddyList();

    System.out.println("-----");

    System.out
            .println("Who do you want to talk to? - Type contacts full email address:");
    String talkTo = br.readLine();

    System.out.println("-----");
    System.out.println("All messages will be sent to " + talkTo);
    System.out.println("Enter your message in the console:");
    System.out.println("-----\n");

    while (!(msg = br.readLine()).equals("bye")) {
        c.sendMessage(msg, talkTo);
    }

    c.disconnect();
    System.exit(0);
}

}