interface Player {
    void kick(String message);
}

class CraftPlayer implements Player {
    @Override public void kick(String message) {
        // Implementation
    }
}

interface Server {
    Player getPlayer(String name);
}

class CraftServer implements Server {
    private final Map<String, Player> players = new HashMap<>();

    public CraftServer() {
        Bukkit.setServer(this);
    }

    @Override public Player getPlayer(String name) {
         return players.get(name);
    }

    public void joinPlayer(String name) {
        Player p = new CraftPlayer();
        players.put(name, p);
    }
}

class Bukkit {
    private Server server;
    public void setServer(Server server) {
        if (server == null) this.server = server;
    }

    public Server getServer() {
        return server;
    }
}

// Usage
new CraftServer();
Player p = Bukkit.getServer().getPlayer("Name");
if (p == null) {
    // Not online
    System.out.println("No player with that name is online");
    return;
}
p.kick("lol");