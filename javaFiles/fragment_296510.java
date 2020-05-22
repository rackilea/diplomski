import java.util.HashSet;

public class Test {

    private static final HashSet<Integer> onetimevisit = new HashSet<Integer>();
    private static final HashSet<Integer> alreadyVisited = new HashSet<Integer>();

    public static void addVisitor(Integer visitorId){
        if(onetimevisit.contains(visitorId))
            alreadyVisited.add(visitorId);
        else
            onetimevisit.add(visitorId);
    }
}