public static void partB() {
    System.out.println("Exercise 1B");
    int count = 0;
    String active = "true";
    int correct = 0;
    while (active == "true") {
        Random r = new Random();
        int Low = 10; //inclusive
        int High = 21; //not inclusive
        int Result = r.nextInt(High - Low) + Low;
        Random r2 = new Random();
        int Result2 = r2.nextInt(High - Low) + Low;
        int Total = Result * Result2;
        Scanner input = new Scanner(System.in);
        System.out.println(Result + "*" + Result2 + "=?");
        String guess = new String(input.nextLine());
        String tostrng = String.valueOf(Total);

        if (guess.equals (tostrng)) {
            correct += 1;
            count+=1;
            System.out.println("Correct answer. Score: " + correct + "(" + count + ")");
        }
       else {
            count +=1;
            System.out.println("Incorrect answer. Score:" + correct + "(" + count + ")");
        }
        if (guess.equals("q")) {
            System.out.println("Good Bye!");
            active = "false";
            //return;
        }
    }
}