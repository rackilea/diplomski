abstract class Vehicle { // parent class
    protected String name;
    protected int numOfWheels;

    public Vehicle(String n, int nw) {
        name = n;
        numOfWheels = nw;
    }

    public abstract void drive();
}

class Engine { // a non public class
    private String type;
    private double power;

    public Engine(String t, double p) {
        type = t;
        power = p;
    }

    @Override
    public String toString() {
        return "Engine [type=" + type + ", power=" + power + "]";
    }
}

public class MotorCar extends Vehicle implements MoveableListener {
    protected String owner;
    protected Engine engine;
    private boolean moveable;

    public MotorCar(String n, int nw, String owner, Engine engine, boolean moveable) {
        super(n, nw);
        this.owner = owner;
        this.engine = engine;
        this.moveable = moveable;
    }

    public void drive() {
        System.out.println("Car is moving");
    }

    public boolean isMoveable() {
        return moveable;
    }

    public void setMoveable(boolean moveable) {
        this.moveable = moveable;
    }

    @Override
    public String toString() {
        return "MotorCar [owner=" + owner + ", engine=" + engine + ", moveable=" + moveable + ", name=" + name
                + ", numOfWheels=" + numOfWheels + "]";
    }

    public static void main(String[] args) {
        MotorCar myCar = new MotorCar("Mazda 1.5", 4, "Lai Kim Min", new Engine("SkyActive", 1.5), true);
        System.out.println(myCar);
        System.out.println("is myCar moveable? " + myCar.isMoveable());
        myCar.setMoveable(false);
        System.out.println("is myCar moveable? " + myCar.isMoveable());    
    }
}