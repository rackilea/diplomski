Scanner sc = new Scanner(System.in);
String input = "";
while (true) {
    System.out.println("Please enter your exam score from 0-100. Press 'E' to Exit");
    input = sc.next();
    if (input.equals("E")) break; // exit loop

    int score = Integer.parseInt(input);
    // check score

}