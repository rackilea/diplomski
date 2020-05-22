final int NUM_OF_SERVERS = 2;

List<Database> databases = new ArrayList<Database>();

// Note the change to starting index
for (int i = 0; i < NUM_OF_SERVERS; i++) {
    Database database = new Database("server" + i + ".txt");
    databases.add(database);
}

List<Server> servers = new ArrayList<Server>();
// Note the change to starting index *and* the use of i rather than i - 1 
for (int i = 0; i < NUM_OF_SERVERS; i++) {
    Server server = new Server(databases.get(i));
    // Use server here
}