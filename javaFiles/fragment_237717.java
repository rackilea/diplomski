public class Main {

    public static void main(String[] args) {
        Contacts contactObj = new Contacts();
        contactObj.getNames().forEach(System.out::println);

        contactObj.cleanNames();
        contactObj.getNames().forEach(System.out::println);

        contactObj.addName("John");
        contactObj.addName("Maria");

        contactObj.getNames().forEach(System.out::println);
    }
}