// ... same code above   
ArrayList<String> cart = new ArrayList<>();

Scanner input = new Scanner(System.in);
String user_item = "";
int user_quantity = 0;
System.out.println("What items would you like to buy?");

// Loop to repeatedly get user input and add items to cart
// until user enters "q" for item to quit.
do {
    System.out.print("Item? (q to quit) ");
    user_item = input.nextLine();
    if (user_item.equals("q")){
        break;
    }
    System.out.print("How many " + user_item + "? ");
    user_quantity = input.nextInt();
    System.out.println(user_quantity + " " + user_item);
    for(int q = 0; q <= user_quantity; q++){
       cart.add(user_item);
    }
} while(!input.nextLine().equals("q"));
input.close();

// Remove these
// cart.add("strawberries");
// cart.add("strawberries");
// cart.add("strawberries");
// cart.add("chocolate chips");
// cart.add("banana");
// cart.add("banana");
// cart.add("apple");
// cart.add("eggs");
// cart.add("butter");

double totalCost = getPrice(getPriceList(), cart);
// ... same code below