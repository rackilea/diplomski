class Cars {
    private  MyMap cars = new MyMap();

    public MyMap getCars() {
        return cars;
    }
    public void setCars(MyMap cars) {
        this.cars = cars;
    }

    public void add(String name, Car car){
        cars.put(name, car);
        cars.setCount(cars.getCount()+1);
    }

}

class MyMap extends HashMap<String, Car> {
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

class Car {
    private int length;
    private int weight;

    public Car() {

    }

    public Car(int length, int weight) {
        this.length = length;
        this.weight = weight;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}