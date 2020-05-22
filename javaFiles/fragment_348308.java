public class Point implements Iterable<Point> {

    // Additional code here
    private Iterator<Point> pointIterator;

    public Point (Iterator<Point> pointIterator) {
        this.pointIterator = pointIterator;
    }
    @Override
    public Iterator<Point> iterator() {
        return pointIterator;
    }


    PeekingIterator<Point> getEnumerator() {
        if (pointIterator instanceof PeekingIterator) {
            return (PeekingIterator<Point>)pointIterator;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Point myPoint = new Point(new PeekingIteratorMock());
        PeekingIterator<Point> myIterator = myPoint.getEnumerator();
        Point p;
        while ((p = myIterator.next()) != null) {
            // Do something usefull here
        }
    }

}