import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class Point2Test {
    private List<Point2> points = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        points.add(new Point2(0.49999999f, 0));
        points.add(new Point2(0.50000001f, 0));
    }
    ...

    @Test
    public void testGetXsnapped() {
        System.out.format("testing xSnapped of two points: %s and %s%n"
                , points.get(0), points.get(1));
        System.out.format("and they are %d and %d respectively%n"
                , points.get(0).getXsnapped()
                , points.get(1).getXsnapped());
        System.out.format("(Note: epsilon is %f)%n"
                , points.get(0).getEps());

        assertEquals(points.get(0).getXsnapped()
                    , points.get(1).getXsnapped());
    }
}