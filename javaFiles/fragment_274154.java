public class St_Johns_University
{
    public static void main(String[] args) {
        System.out.printf("%-10s%-10s%-10s%-10s%-10s\n", "Radians", "Tangent", "Sine", "Cosine", "Degrees");

        int degrees = 60;
        double radians = Math.toRadians(degrees);
        System.out.printf("%-10f%-10.4f%-10.4f%-10.4f%-10d\n", radians, Math.tan(radians), Math.sin(radians), Math.cos(radians), degrees);
         degrees = 80;
         radians = Math.toRadians(degrees);
        System.out.printf("%-10f%-10.4f%-10.4f%-10.4f%-10d\n", radians, Math.tan(radians), Math.sin(radians), Math.cos(radians), degrees);
         degrees = 100;
         radians = Math.toRadians(degrees);
        System.out.printf("%-10f%-10.4f%-10.4f%-10.4f%-10d\n", radians, Math.tan(radians), Math.sin(radians), Math.cos(radians), degrees);
         degrees = 130;
         radians = Math.toRadians(degrees);
        System.out.printf("%-10f%-10.4f%-10.4f%-10.4f%-10d\n", radians, Math.tan(radians), Math.sin(radians), Math.cos(radians), degrees);
         degrees = 160;
         radians = Math.toRadians(degrees);
         System.out.printf("%-10f%-10.4f%-10.4f%-10.4f%-10d\n", radians, Math.tan(radians), Math.sin(radians), Math.cos(radians), degrees);
    }
}