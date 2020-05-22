public class Node {

    private String mediName;
    private String dayOfWeek;
    private String expiry;
    private String manufacturer;


    public Node(String mediName,String dayOfWeek,String expiry,String manufacturer)
    {
        this.mediName=mediName;
        this.dayOfWeek=dayOfWeek;
        this.expiry=expiry;
        this.manufacturer=manufacturer;
    }


    public String getMediName() {
        return mediName;
    }
    public void setMediName(String mediName) {
        this.mediName = mediName;
    }
    public String getDayOfWeek() {
        return dayOfWeek;
    }
    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
    public String getExpiry() {
        return expiry;
    }
    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }


}