import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;


public class SegmentSet <T> {   
    private List<Segment> segments = new ArrayList<Segment>();  

    //note that x2 is inclusive
    public void add(int x1, int x2, T identity) {
        segments.add(new Segment(x1,x2, identity));
    }

    public List<SimpleEntry<T, T>> getAllIntersectingPairs() {
        // Build a list of all segment edges
        ArrayList<Edge> edges = new ArrayList<Edge>(2 * segments.size());
        int i=0;
        for(Segment seg : segments) {
            edges.add(new Edge(EdgeType.START, seg.x1, seg));
            edges.add(new Edge(EdgeType.END, seg.x2, seg));
        }

        // Sort the edges in ascending order
        Collections.sort(edges);

        // Sweep
        ArrayList<SimpleEntry<T, T>> res = new ArrayList<SimpleEntry<T, T>>();
        HashMap<Segment, Object> currSegments = new HashMap<Segment, Object>();
        for (Edge edge : edges) {
            if (edge.type == EdgeType.START) {
                for (Segment seg : currSegments.keySet())
                    res.add(new SimpleEntry<T, T>(edge.seg.identity, seg.identity));
                currSegments.put(edge.seg, null);
            } else {
                currSegments.remove(edge.seg);
            }
        }

        return res;
    }

    public class Segment {
        public final int x1;
        public final int x2;
        public final T identity;

        public Segment(int x1, int x2, T identity) {
            this.x1 = x1;
            this.x2 = x2;
            this.identity = identity;
        }
    }

    private enum EdgeType {START, END};

    private class Edge implements Comparable<Edge>{
        public final EdgeType type;
        public final int x;
        public Segment seg;

        public Edge(EdgeType type, int x, Segment seg) {
            this.type = type;
            this.x = x;
            this.seg = seg;
        }

        @Override
        public int compareTo(Edge o) {
            if (x > o.x)
                return 1;
            if (x < o.x)
                return -1;
            // A start Edge will come before an end edge in case of equal X value
            return type.ordinal() - o.type.ordinal();
        }
    }

    public static void main(String[] args) {
        SegmentSet<String> set = new SegmentSet<String>();
        set.add(10,100,"A");
        set.add(110,200,"B");
        set.add(0,400,"C");
        System.out.println(set.getAllIntersectingPairs());
    }
}