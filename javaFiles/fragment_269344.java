public class Circle extends GeometricObject {
    int answer;
    public void multiplication(int x, int y) {
        answer = x * y;
        System.out.println("The product is :" + answer);
    }

    public static void main(String arg[]) {
        int a = 11, b = 8;
        GeometricObject circle1 = new Circle();
        circle1.addition(a, b);
        circle1.substraction(a, b);
        // circle1.multiplication(a, b); cannnot call the method. Its undifined for the GeometricObject

        Circle circle2 = new Circle();
        circle2.addition(a, b);
        circle2.substraction(a, b);
        circle2.multiplication(a, b);
    }
}