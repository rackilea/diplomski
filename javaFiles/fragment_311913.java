import java.util.LinkedList;
import java.util.PriorityQueue;

public class DijkstraTest
{
  public static PathSegment Dijkstra(
      final Vertex from,
      final Vertex to,
      final int maxSize
  )
  {
    if ( from == null )
      throw new IllegalArgumentException( "From vertex cannot be null" );
    if ( to == null )
      throw new IllegalArgumentException( "To vertex cannot be null" );
    if ( maxSize <= 0 )
      throw new IllegalArgumentException( "Maximum size must be at least 1" );
    final PriorityQueue<PathSegment> queue = new PriorityQueue<>();

    for ( final Edge e : from.outEdges )
      queue.add( new PathSegment( e, null ) );

    while ( !queue.isEmpty() )
    {
      final PathSegment p = queue.poll();
      final Edge e   = p.edge;
      final Vertex v = e.to;
      if ( v == to )
      {
        // Found a path to destination
        return p;
      }
      if ( p.size == maxSize )
      {
        // Not reached the destination but at max length so discard this path
        continue;
      }
      for ( final Edge o : v.outEdges )
      {
        if ( o.length > e.length ) // Increasing edges
        {
          queue.add( new PathSegment( o, p ) );
        }
      }
    }

    return null;
  }

  public static class Vertex{
    public final int index;
    public final LinkedList<Edge> outEdges = new LinkedList<>();
    public Vertex( final int i )
    {
      index = i;
    }
  }

  public static class Edge{
    public final Vertex from;
    public final Vertex to;
    public final int length;
    public Edge( final Vertex f, final Vertex t, final int l )
    {
      from = f;
      to = t;
      length = l;
      from.outEdges.add( this );
    }
  }

  public static class PathSegment implements Comparable<PathSegment>{
    public final Edge edge;
    public final PathSegment prev;
    public final int length;
    public final int size;
    public PathSegment( final Edge e, final PathSegment p )
    {
      edge = e;
      prev = p;
      size   = ( prev == null ? 0 : prev.size ) + 1;
      length = ( prev == null ? 0 : prev.length ) + edge.length;
    }

    @Override
    public int compareTo( final PathSegment p )
    {
      return Integer.compare( length, p.length );
    }

    @Override
    public String toString(){
      return ( prev == null ? Integer.toString( edge.from.index ) : prev.toString() )
             + ','
             + Integer.toString( edge.to.index );
    }
  }

  public static void main( final String[] args )
  {
    final Vertex[] vertices = {
      new Vertex(1), new Vertex(2), new Vertex(3), new Vertex(4), new Vertex(5), new Vertex(6)
    };

    final Edge[] edges = {
      new Edge(vertices[0],vertices[1],2),
      new Edge(vertices[0],vertices[2],7),
      new Edge(vertices[0],vertices[5],5),
      new Edge(vertices[1],vertices[0],11),
      new Edge(vertices[1],vertices[2],3),
      new Edge(vertices[2],vertices[3],8),
      new Edge(vertices[2],vertices[4],1),
      new Edge(vertices[3],vertices[1],10),
      new Edge(vertices[3],vertices[4],6),
      new Edge(vertices[5],vertices[3],4),
      new Edge(vertices[5],vertices[3],7)
    };

    PathSegment p;

    p = Dijkstra( vertices[0], vertices[3], 2 );
    System.out.println( p + " - length: " + (p==null?"null":p.length) );

    p = Dijkstra( vertices[2], vertices[0], 2 );
    System.out.println( p + " - length: " + (p==null?"null":p.length) );

    p = Dijkstra( vertices[2], vertices[0], 3 );
    System.out.println( p + " - length: " + (p==null?"null":p.length) );
  }
}