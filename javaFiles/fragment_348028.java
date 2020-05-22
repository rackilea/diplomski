public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("wifi-dbPU");
        DeviceJpaController deviceController = new DeviceJpaController(emf);
        NetworkInterfaceJpaController netController = new NetworkInterfaceJpaController(emf);

        Device device = new Device("laptop");                 // 1
        deviceController.create(device);                      // 2

        NetworkInterface net = new NetworkInterface("eth0");  // 3
        net.setDeviceId(device.getId());                      // 4
        netController.create(net);                            // 5 
        // The parent collection is updated by the above create     
    }
}