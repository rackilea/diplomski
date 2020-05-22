public class Rectangle {

    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getCircumference() {
        return 2*width+2*height;
    }

    @Override
    public String toString() {
        return "Rectangle["+width+","+height+"]Area:"+getArea()+",Circumference:"+getCircumference();
    }

    public static void main(String[] args) {
         Scanner console=new Scanner(System.in);
        double width = getValue(console, "Width");
        double height = getValue(console, "Height");
        Rectangle rectangle = new Rectangle(width, height);
        System.out.println(rectangle);

    }

    public static double getValue(Scanner console, String name) {
        System.out.println("Enter "+name + " : ");
        String widthStr = console.nextLine();
        double parseDouble;
        try {
            parseDouble = Double.parseDouble(widthStr);
        }catch(NumberFormatException ne) {
            System.out.println("Unable to parse your input, enter correct value ");
            return getValue(console, name);
        }
        return parseDouble;
    }
}