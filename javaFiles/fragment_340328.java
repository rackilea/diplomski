public class Test {
    public Point homePoint;

    public static void main(String[] args) {
        Point p = new Point(4, 3);
        Test test = new Test();

        System.out.println("test1:");
        test.test1(p);
        System.out.println("home point : " + test.homePoint);
        System.out.println("p          : " + p);
        p.x = 8;
        System.out.println("home point : " + test.homePoint);
        System.out.println("p          : " + p);

        System.out.println("test2:");
        test.test2(p);
        System.out.println("home point : " + test.homePoint);
        System.out.println("p          : " + p);
        p.x = 4;
        System.out.println("home point : " + test.homePoint);
        System.out.println("p          : " + p);


    }

    public void test1(Point point) {
        homePoint = new Point(point.x, point.y);
    }

    public void test2(Point point) {
        homePoint = point;
    }
}