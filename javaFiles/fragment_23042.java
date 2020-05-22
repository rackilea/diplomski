public class CarDriver {

    private String name;  
    private int age;

    // You need to store the tracker as a field!
    private CarDriver tracker;

    public CarDriver(String name, int age){
        this.age = age;
        this.name = name;
    }

    public CarDriver(String name, int age, CarDriver tracker){
        this.name = name;
        this.age = age;
        // the above two lines can be simplfied to:
        // this(name, age);

        // assign the tracker passed in to the field
        this.tracker = tracker;
    }

    public String getName(){
        return  this.name;
    }
    public int getAge(){
        return this.age;
    }

    // Use CarDriver as the return type
    public CarDriver getTracker(){
        return tracker;
    }

    // I have edited this method slightly because it doesn't really makes sense
    // to do something like "driver.hasPursuer(driver)". It makes much more
    // sense to do "driver.hasPursuer()"
    public boolean hasPursuer()
    {
        // you don't actually need an if statement here. "!=" already evaluates to a boolean
        // also note that when there is no pursuers, the value is "null", not "0"
        return getTracker() != null;
    }

    public static void main(String[] args) {
        CarDriver driver1 = new CarDriver("Hamilton", 25);
        CarDriver driver2 = new CarDriver("Schumacher", 23, driver1);
        CarDriver driver3 = new CarDriver("Rosberg", 27, driver2);
        CarDriver driver4 = new CarDriver("Susi", 27, driver3);

        System.out.println(driver1.hasPursuer() + " " + driver2.hasPursuer());
    }

}