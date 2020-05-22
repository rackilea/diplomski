public static void main(String args[]) {
    String first = JOptionPane.showInputDialog(null,"Enter your first name");
    // You should be checking the return result, but any way...
    Person person = new Person();
    person.name = first;

    La la = new La(person);

}

public class La {
    public La(Person person) {
        System.out.println(person.name);
    }
}