@Before
public void setUp() throws Exception {
    Point2 dummy = new Point2(0, 0);    // just to get epsilon
    points.add(new Point2(dummy.getEps()*0.5, 0));
    points.add(new Point2(dummy.getEps()*0.49999999999999, 0));
}