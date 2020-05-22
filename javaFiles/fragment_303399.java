import java.util.ListIterator;

import com.hp.hpl.jena.graph.Triple;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.sparql.core.TriplePath;
import com.hp.hpl.jena.sparql.core.Var;
import com.hp.hpl.jena.sparql.syntax.ElementPathBlock;
import com.hp.hpl.jena.sparql.syntax.ElementVisitorBase;
import com.hp.hpl.jena.sparql.syntax.ElementWalker;

public class ElementWalkerExample {
    public static void main(String[] args) {
        final String queryString  = "" +
            "SELECT * WHERE {\n" +
            " ?a ?b ?c1 ;\n" +
            "    ?b ?c2 .\n" +
            " ?d ?e ?f .\n" +
            " ?g ?h ?i .\n" +
            "{ ?p ?q ?r .\n" +
            "  ?d ?e2 ?f2 . }\n" +
            "}";
        final Query query = QueryFactory.create( queryString );
        System.out.println( "== before ==\n"+query );
        ElementWalker.walk( query.getQueryPattern(), 
                new ElementVisitorBase() {
                    @Override
                    public void visit(ElementPathBlock el) {
                        ListIterator<TriplePath> it = el.getPattern().iterator();
                        while ( it.hasNext() ) {
                            final TriplePath tp = it.next();
                            final Var d = Var.alloc( "d" );
                            if ( tp.getSubject().equals( d )) {
                                it.add( new TriplePath( new Triple( d, d, d )));
                            }
                        }
                    }
        });
        System.out.println( "== after ==\n"+query );
    }
}