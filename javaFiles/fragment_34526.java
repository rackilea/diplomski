public final class DepotDatabase {
private Driver[] arrayDrivers;

public void printArray() {
    for (int i = 0; i < arrayDrivers.length; i++) {
        Driver d = arrayDrivers[i];

        System.out.println("Username : " + d.getUsername());
        System.out.println("Password : " + d.getPassword());
        System.out.println(" Manager Check: " + d.getManagerCheck());

    }
}