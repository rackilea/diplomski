public class SalesPersonMain {

public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    CopyOnWriteArrayList<SalesPerson> sPerson = new CopyOnWriteArrayList<>(); //List will fail in case of remove due to ConcurrentModificationException

    while (true) {
        System.out.println("Enter id (press 'q' to quit): ");
        String temp = input.nextLine();
        if (temp.equals("q")) break;

        int id = Integer.parseInt(temp);

        System.out.println("Enter first name:");
        String firstName = input.nextLine();

        System.out.println("Enter last name:");
        String lastName = input.nextLine();
        sPerson.add(new SalesPerson(id, firstName, lastName));

    }
    //Search
    System.out.println("Enter String to search & display");
    String searchString = input.nextLine();
    for (SalesPerson salesPerson : sPerson) {
        if(salesPerson.search(searchString)!=null){
            System.out.println(salesPerson.toString());
        }
    }
    //Remove
    System.out.println("Enter String to search & remove");
    searchString = input.nextLine();
    for (SalesPerson salesPerson : sPerson) {
        if(salesPerson.search(searchString)!=null){
            System.out.println(salesPerson.toString()+" is removed from the List");
            sPerson.remove(salesPerson);
        }
    }
    //Display All
    System.out.println("Final List : ");
    for (SalesPerson salesPerson : sPerson) {
        System.out.println(salesPerson.toString());
    }
}