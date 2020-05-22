public class AddressProvider {
    private static AddressProvider ourInstance = new AddressProvider();
    private String urlAddress;

    private AddressProvider() {
    }

    public static AddressProvider getInstance() {
        return ourInstance;
    }

    public String getAddress() {
        return urlAddress;
    }

    public void setAddress(String urlAddress) {
        this.urlAddress = urlAddress;
    }
}