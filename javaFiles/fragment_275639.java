import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraph;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.Tokens.*;
import com.tinkerpop.gremlin.java.GremlinPipeline;

import java.util.Arrays;

/**
 * @author Daniel Kuppitz (daniel at thinkaurelius.com)
 */
public class App {

    public static void main(final String[] args) throws Exception {

        final TinkerGraph g = TinkerGraphFactory.createTinkerGraph();
        new GremlinPipeline<Vertex, Vertex>(g).V()
                .has("name", T.in, Arrays.asList("marko","josh")).map()
                .forEach(System.out::println);
    }
}