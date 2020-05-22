public static void main(String [] args) {

        Rectangle r1 = new Rectangle(10,10,10,10);
        Rectangle r2 = new Rectangle(10,10,10,10);
        System.out.println(createIntersection(r1, r2));

        r1 = new Rectangle(10,10,10,10);
        r2 = new Rectangle(15,15,10,10);
        System.out.println(createIntersection(r1, r2));

        r1 = new Rectangle(20,20,10,10);
        r2 = new Rectangle(15,15,10,10);
        System.out.println(createIntersection(r1, r2));

        r1 = new Rectangle(15,30,10,10);
        r2 = new Rectangle(15,15,10,10);
        System.out.println(createIntersection(r1, r2));

        r1 = new Rectangle(15,30,10,10);
        r2 = new Rectangle(15,15,10,20);
        System.out.println(createIntersection(r1, r2));
 }