public class DOTTest {

    public static void main(String[] args) throws ImportException {
        //Example graph
        String input =
                "digraph graphname {\r\n" + "     a -> b -> c;\r\n" + "     b -> d;\r\n" + " }";

        GraphImporter<String, DefaultEdge> importer = new DOTImporter<>(
                (label, attributes) -> label, 
                (from, to, label, attributes) -> new DefaultEdge()
        );

        Graph<String, DefaultEdge> result = new SimpleDirectedGraph<>(DefaultEdge.class);
        importer.importGraph(result, new StringReader(input));

        System.out.println(result);
    }
}