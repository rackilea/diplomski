public class HelpCommandHandler extends AbstractCommand { /* !help */
    @Override
    public void execute(Sender sender, String[] args) {
        sender.sendMessage("You asked for help."); // Your code might not work like this.
    }
}

public class ChangeNickCommandHandler extends AbstractCommand { /* !changenick newNick */
    @Override
    public void execute(Sender sender, String[] args) {
        // I assume you have a List with connected players in your Server class
        String username = sender.getUsername(); // Your code might not work like this
        Server server = Server.get(); // Get Server instance
        server.getUsers().get(username).setNickname(args[0]); // Argument 0. Check if it even exists.
    }
}

// Server class. If it isn't singleton, you can make it one like this:
public class Server {
    private static Server self;
    public static Server init(/* Your args you'd use in a constructor */) { self = new Server(); return get(); }
    public static Server get() { return self; }

    private List<User> users = new List<User>();
    private HashMap<String, AbstractCommand> commandRegitry = new HashMap<>();

    // Make construcor private, use init() instead.
    private Server() {
        commandRegistry.put("help", new HelpCommandHandler());
        commandRegistry.put("changenick", new ChangeNickCommandHandler());
    }

    // Getters
    public List<User> getUsers() {
        return users;
    }

    public HashMap<String, AbstractCommand> getRegistry() {
        return commandRegistry;
    }
}