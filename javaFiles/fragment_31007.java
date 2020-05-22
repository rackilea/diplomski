public class Vehicle {

    public void crankIgnition(){
        Engine sixLiterEngine = new Engine("6 Liter Engine");
        sixLiterEngine.startEngine();
        System.out.println("Vehicle is running");
    }
}