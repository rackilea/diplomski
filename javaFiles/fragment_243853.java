Scanner scanner = new Scanner(System.in);
System.out.println("Enter the words");
String input = scanner.nextLine(); // variable to store every input line
String fruits = "";        // this should store all the inputs in one string
while(! input.equals("stop")) {
     fruits += input + ",";  // using comma to separate the inputs  
     input = scanner.nextLine();
}
String[] res = fruits.split(","); // splitting the string to have its content in an array