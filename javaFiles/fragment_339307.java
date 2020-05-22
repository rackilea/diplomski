public class Rectangle {
    protected double length;
    protected double width;
    protected double perimeter;

    public void calculatePerimeter() {
        perimeter = (2*length) +(2*width);
    }

    public static void main(String[] args) {
        Rectangle square = new Rectangle() {
            public void calculatePerimeter() {
                perimeter = 4*length;
            }
        };
    }

}