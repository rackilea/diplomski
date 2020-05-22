public class PersonArrayTest {

    public static void main(String[] args) {
        String[] listOfPeople = new String[5];
        assign(listOfPeople);
        System.out.println(Arrays.toString(listOfPeople));
    }

    public static void assign(String[] listOfPeople) {

        Scanner scnr = new Scanner(System.in);
        for (int i = 0; i < listOfPeople.length; i++) {
            String name = scnr.nextLine();
            System.out.println("Person " + (i) + ": ");
            listOfPeople[i] = name;
        }
    }
}