@Root
public class PhoneNumbers {
    @ElementArray(name="numbers", entry = "phone")
    private String[] phones;

    public PhoneNumbers(String[] phones) {
        this.phones = phones;
    }
}