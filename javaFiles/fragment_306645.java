public interface Wheel {
    void setSize(int diameter);
}

public static abstract class Car<T extends Wheel> {

    private List<T> wheels = new ArrayList<T>();

    protected Car(int numberOfWheels, Class<T> wheelClass) {
        while (wheels.size() < numberOfWheels) {
            T wheel;
            try {
                wheel = wheelClass.newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e); // simplified exception handling
            }
            wheel.setSize(5); // Ask user for wheel details etc
            wheels.add(wheel);
        }
    }

    public List<T> getWheels() {
        return wheels;
    }
}

public static class PlasticWheel implements Wheel { // or extends Wheel
    @Override
    public void setSize(int diameter) {
    }
}

public static class ToyCar extends Car<PlasticWheel> {
    public ToyCar() {
        super(6, PlasticWheel.class); // or you could pass number of wheels in to this constructor
    }
}

public static class TreadedWheel implements Wheel { // or extends Wheel

    @Override
    public void setSize(int diameter) {
    }
}

public static class MonsterTruckCar extends Car<TreadedWheel> {
    public MonsterTruckCar() {
        super(4, TreadedWheel.class); // or you could pass number of wheels in to this constructor
    }
}