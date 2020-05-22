private final List<ServerInfo> listOfServers = new ArrayList<ServerInfo>();

public void insertIntoList() {
    for (int i = 0; i < 1000000; i++)
        listOfServers.add(new ServerInfo(i, (int) (200 + Math.random() * 200)));
}

public static void main(String[] args) {
    MyApp s = new MyApp();
    s.insertIntoList();
    ServerInfoComparator com = new ServerInfoComparator();
    long start = System.nanoTime();
    Collections.sort(s.listOfServers, com);
    long time = System.nanoTime() - start;
    System.out.printf("Sorting %,d took %.3f seconds%n", s.listOfServers.size(), time/1e9);

    for (ServerInfo server : s.listOfServers) {
//    System.out.println(server);
    }
}