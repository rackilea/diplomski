public class DriverFactory {

private static final ThreadLocal<Map<String, String>> driverData = new InheritableThreadLocal<>();


public static String getDriverData(String key){
    return driverData.get().get(key);
}   

public static void setDriverData(Map<String, String> driver){
    driverData.set(driver);
}