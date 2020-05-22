public class Problem {

public static class Rectangle {

    double x0;
    double y0;
    double x1;
    double y1;

    Rectangle(double x0, double y0, double x1, double y1) {

        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;

    }

}

public static void main(String[] args) {

    Rectangle A = new Rectangle(2.0, 2.0, 10.0, 5.0);
    Rectangle B = new Rectangle(0.0, 0.0, 6.5, 3.5);
    double area = 0.0;


    if(A.x1 - B.x0 > 0 && A.y1 - B.y1 > 0) {

        System.out.println("they're overlaping");
        area = (A.x1 - B.x0) * (A.y1 - B.y1);
        System.out.println(area);

    } else if  (B.x1 - A.x0 > 0 && B.y1 - A.y1 > 0) {

        System.out.println("they're overlaping");
        area = (B.x1 - A.x0) * (B.y1 - A.y1);
        System.out.println(area);

    } else if (other conditions....) {

        // you're code here
    }


}

}