public class Area {
double pi = 3.14;
int r;
int h;

void areaOfCircle() {
    double area1 = pi * r * r;
    System.out.println("area of circle=" + area1);
}

void areaOfCylinder() {
    double area2 = 2 * pi * r * (r + h);
    System.out.println("area of cylinder=" + area2);
}

public static void main(String args[]) {

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the value of r");
    Area a = new Area();
    a.r = sc.nextInt();
    System.out.println("enter the value h");
    a.h = sc.nextInt();
    a.areaOfCircle();
    a.areaOfCylinder();
   }
}