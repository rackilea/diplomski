public class Intersection{
    public final long latitude;
    public final long longitude;
    public Intersection(long latitude, long longitude){ ...}
}

public class Street extends DefaultWeightedEdge{
    public final String streetName;
    public final int speedLimit;
    public final Street(...){...}
}

public class RoadNetwork{
    public final Graph<Intersection, Street> network=new DefaultDirectedGraph<>(Street.class);
    Intersection i1=new Intersection(..);
    Intersection i2=new Intersection(..);
    Street s=new Street(..);

    //Network with 1 street
    network.addVertex(i1);
    network.addVertex(i2);
    network.addEdge(i1,i2,s);
}