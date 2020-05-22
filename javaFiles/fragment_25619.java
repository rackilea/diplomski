public class Main {

    public static void main(String[] args) {

        GraphDatabaseFactory graphDbFactory = new GraphDatabaseFactory();
        GraphDatabaseService graphDb = graphDbFactory.newEmbeddedDatabase("C:\\Zakaria\\NeoTests\\Tetralecture");

        ExecutionEngine execEngine = new ExecutionEngine(graphDb);

/* Here is a loop to read from listA and listB so no need to worry about them */

        try (Transaction ignored = graphDb.beginTx()) {
            String query = "MATCH (auteur1:AUTEUR{Name:'" + listA.get(i) + "'}), (auteur2:AUTEUR{Name:'" + listB.get(j) + "'}) return auteur1, auteur2";
            ExecutionResult execResult = execEngine.execute(query);
            for(Map<String, Object> row : execResult) {
                final Node node1 = (Node)row.get("auteur1");
                final Node node2 = (Node)row.get("auteur2");
                String nodeResult = node1 + " : " + node1.getProperty("Name") + "; " + node2 + " : " + node2.getProperty("Name");
                System.out.println(nodeResult);
            }
        }

    }

}