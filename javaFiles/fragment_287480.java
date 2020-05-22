public static void List<String> initFruits() {
    ArrayList<String> theFruit = new ArrayList<String>();
    theFruit.add("Plums");
    theFruit.add("Grapes");
    theFruit.add("Oranges");
    theFruit.add("Prunes");
    theFruit.add("Apples");
    return theFruit;
}

public static void viewAllFruit(List<String> fruits,String CustomerRef[])
{
    for (String fruit : fruits) {
        System.out.println("Fruit " + fruit + " is in stock ");   
    }
}

public static void addFruit(List<String> fruits,String CustomerRef[])
{

    Scanner input = new Scanner(System.in);
    String EE = "EE"; //you assked for EE as quit but you wanted to compare with "Goodbye!";

    while(true) {
        System.out.println("Enter the fruits you'd like to add and EE to exit");
        String choice = input.next();


        if (choice.equals(EE)) {
           break;
        };

        fruits.add(choice);
    }
}

public static void TheMenu()
{
    String Customer[] = new String[10]; 

    Scanner input = new Scanner(System.in);
    List<String> fruits = initFruits();


    String option; 
    do {   // loop back to here as long as Q isn't selected           
    System.out.println("\nMenu");
    System.out.println("V: Views all fruit");
    System.out.println("A: To add a fruit to the list");
    System.out.println("Q: To exit");

    option = input.next();  

    if (option.charAt(0) == 'V' ) 
    { 
        viewAllFruit(fruits,Customer);
    } 


    if (option.charAt(0) == 'A' ) 
    { 
        addFruit(fruits,Customer);
    }

    }
    while (option.charAt(0) != 'Q');

}