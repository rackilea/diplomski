public class Tester {
  public static void main(String [] args) throws Exception {
    // Make a service
    AddressBookService service = new AddressBookServiceLocator();

    // Now use the service to get a stub which implements the SDI.
    AddressBook port = service.getAddressBook();

    // Make the actual call
    Address address = new Address(...);
    port.addEntry("Russell Butek", address);
  }
}