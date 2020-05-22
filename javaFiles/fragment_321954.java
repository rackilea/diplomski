public class Actor {
    int id;
    long serialNumber;
    String name;
    double height;

    //Constructor with parameters
    public Actor(int id, long serialNumber, String name, double height) {
        id=Id;
        serialNumber=SerialNumber;
        name =Name;
        height= Height;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public long getSerialNumber() {
        return serialNumber;
    }
    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

}