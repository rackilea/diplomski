import java.io.IOException;

import com.orientechnologies.orient.client.remote.OServerAdmin;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientEdge;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import com.tinkerpop.blueprints.impls.orient.OrientGraphFactory;

public class Stack37046827 {
private static String remote = "remote:localhost/";

public static void main(String[] args) {
    try {
        String DBname = "Stack37046827";
        String currentPath = remote + DBname;
        OServerAdmin serverAdmin = new OServerAdmin(currentPath).connect("root", "root");
        OrientGraphFactory factory = new OrientGraphFactory(currentPath);
        OrientGraph g = factory.getTx();
        Iterable<Vertex> delears = g.getVerticesOfClass("Delears");
        Iterable<Vertex> sMarkets = g.getVerticesOfClass("SuperMarket");
        for (Vertex delear : delears) {
            for (Vertex sMarket : sMarkets) {
                if (delear.getProperty("Name").equals("name0") && sMarket.getProperty("Item").equals("item0")) {
                    OrientEdge e1 = g.addEdge(null, delear, sMarket, "myEdge");
                    g.commit();
                    System.out.println(e1);
                }
            }
        }
        g.shutdown();
        serverAdmin.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}