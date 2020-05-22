import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class EdgeComparator implements Comparator<Edge> {
    public int compare(Edge l, Edge r) { ... }
}

void yourCode() {
    List<Edge> edges = ...;
    Collections.sort(edges, new EdgeComparator());
    //edges now contains the sorted edges
}