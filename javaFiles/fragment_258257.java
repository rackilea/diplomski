@Data
@NoArgsConstructor
@AllArgsConstructor
class Server {
    private String name;
    private String attribute1;
    private String attribute2;
}

public class ServerMain {

    public static void main(String[] args) {

        List<Server> servers1 = Arrays.asList(
                new Server("name1", "attr1.1", null),
                new Server("name2", "attr1.2", null));

        List<Server> servers2 = Arrays.asList(
                new Server("name1", null, "attr2.1"),
                new Server("name2", null, "attr2.2"));

        Map<String, Server> serverMap1 = servers1.stream().collect(Collectors.toMap(Server::getName, Function.identity()));
        Map<String, Server> serverMap2 = servers2.stream().collect(Collectors.toMap(Server::getName, Function.identity()));

        serverMap1.keySet().forEach(key -> serverMap1.merge(key,
                serverMap2.get(key),
                (server1, server2) -> {
                    server1.setAttribute2(server2.getAttribute2());
                    return server1;
                }));


        System.out.println(serverMap1);
    }
}