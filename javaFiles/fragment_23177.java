public class Guest {
    private String firstName;
    private String lastName;
    public void setBothNames(String bothNames) {
        String[] split = bothNames.split(" ");
        firstName = split[0];
        lastName = split[1];
    }