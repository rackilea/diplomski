Scanner input = new Scanner(System.in);
HashMap<String, String> hMap = getInfo();
String state = "";
do {
    System.out.print("Enter a state, or \"done\" when finished: ");
    state = input.next();
    System.out.println("The capital is " + hMap.get(state));
} while (!state.equals("done"));