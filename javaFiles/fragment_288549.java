public class MyClass {

    private double meters; // Distance as set by the user.
    private String input; // Input by the user.
    private char conversion; // Code for the type of conversion.
    private double kilometers; // The kilometers from the conversion.
    private double inches; // The inches from the conversion.
    private double feet; // The feet from the conversion.

    public static void showKilometers(double meters)
    {
       kilometers = meters * 0.001;
       System.out.println(meters + " meters converted to kilometers becomes: " + kilometers + "km");
    }
}