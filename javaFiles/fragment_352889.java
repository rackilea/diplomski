public class working {

    public static void main(String[] args) {
        temperature freezing = new temperature(32,0,0);
        temperature boiling = new temperature(212,100,33);
        temperature human = new temperature(98.6,37,12.21);

        System.out.println("water freezes at " + freezing.getFahrenheit() + " Fahrenheit, " + freezing.getCelsius() + " Celisus, and " + freezing.getNewton() + " Newton");
        System.out.println("water boils at " + boiling.getFahrenheit() + " Fahrenheit, " + boiling.getCelsius() + " Celisus, and " + boiling.getNewton() + " Newton");
        System.out.println("human body temperature is " + human.getFahrenheit() + " Fahrenheit, " + human.getCelsius() + " Celisus, and " + human.getNewton() + " Newton");

    }
} 

class temperature {
    public temperature (double f, double b, double h) {
        Fahrenheit = f; // <==== ADD?
        Celsius = b; // <==== ADD?
        Newton = h; // <==== ADD?
    }
    double Fahrenheit;
    double Celsius;
    double Newton;
    public void setTemp(double Fahrenheit, double Celsius, double Newton){
        setFahrenheit(Fahrenheit);
        setCelsius(Celsius);
        setNewton(Newton);
    }

    public double getNewton() {
        return Newton;
    }
    public double getCelsius() {
        return Celsius;
    }
    public double getFahrenheit() {
        return Fahrenheit;
    }
    public void setFahrenheit(double Fahrenheittemp){
        Fahrenheit = Fahrenheittemp;
    }
    public void setCelsius(double Celsiustemp){
        Celsius = Celsiustemp;
    }
    public void setNewton(double Newtontemp){
        Newton = Newtontemp;
    }
}