public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.println("Please enter the details of your order");
    String myString = scan.nextLine();
    char[] myChars = myString.toCharArray();

    Map<Character, String> map = new HashMap<>();
    map.put('a', "apple");
    map.put('s', "spinache");
    map.put('d', "dog");
    map.put('f', "fish");
    map.put('g', "goat");


    //Print all the array elements
    for (int i = 0; i < myChars.length; i++) {
        System.out.print(map.get(myChars[i]) + " ");
    }
}