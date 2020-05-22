public class TemperatureConverter {

    private TemperatureConverter() {}

    public static double celciusToFarenheit(double celcius) {
        return 1.8*celcius + 32.0;    
    }

    public static double farenheitToCelcius(double farenheit) {
        return (farenheit - 32.0)/1.8;
    }
}