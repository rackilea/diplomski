Scanner input = new Scanner(System.in);

ArrayList<String> items = new ArrayList<>();

System.out.print("Write down the name of item without any space.\n(i.e.; Green Paper = GreenPaper)\n\nWrite "END" to finish entering items\n\nItems list: \n");


while(true) {
    String item = input.next();
    if (item.equals("END")) {
        break;
    }
    items.add(item);
}

// search in the items list

String search = " ";
System.out.print("Enter the name of the item to check if you have listed: " + search);
search = input.next();
System.out.print(items.indexOf(search));
input.close();// it will stop taking the input