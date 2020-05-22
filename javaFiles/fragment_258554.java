import java.io.IOException;

import com.orientechnologies.orient.client.remote.OServerAdmin;
import com.orientechnologies.orient.core.metadata.schema.OType;
import com.tinkerpop.blueprints.impls.orient.OrientEdge;
import com.tinkerpop.blueprints.impls.orient.OrientEdgeType;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import com.tinkerpop.blueprints.impls.orient.OrientVertex;
import com.tinkerpop.blueprints.impls.orient.OrientVertexType;

public class Stack37046827 {

private static String remote = "remote:localhost/";

public static void main(String[] args) {

    try {

        String DBname = "Stack37046827";
        String currentPath = remote + DBname;

        OServerAdmin serverAdmin = new OServerAdmin(currentPath).connect("root", "root");

        OrientGraph g = new OrientGraph(currentPath);

        // OrientVertexType used to create classes

        OrientVertexType v = g.createVertexType("Delears");
        v.createProperty("ID", OType.INTEGER);
        v.createProperty("Name", OType.STRING);
        v.createProperty("Address", OType.STRING);

        OrientVertexType v1 = g.createVertexType("SuperMarket");
        v1.createProperty("Item", OType.STRING);
        v1.createProperty("Code", OType.DOUBLE);
        v1.createProperty("Quantity", OType.INTEGER);

        OrientEdgeType e = g.createEdgeType("myEdge", "E");

        // Once classes and properties are created, you can populate the DB

        // OrientVertex used to create the vertexes

        OrientVertex delears = g.addVertex("class:Delears");
        delears.setProperties("ID", "1");
        delears.setProperties("Name", "name1");
        delears.setProperties("Address", "address1");

        OrientVertex superMarket = g.addVertex("class:SuperMarket");
        superMarket.setProperties("Item", "item1");
        superMarket.setProperties("Code", "2");
        superMarket.setProperties("Quantity", "5");

        // OrientEdge to create the edge between vertexes

        OrientEdge e1 = g.addEdge(null, delears, superMarket, "myEdge");

        g.shutdown();

        serverAdmin.close();

    } catch (IOException e) {

        e.printStackTrace();

    }

}

}