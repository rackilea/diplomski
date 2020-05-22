public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    List<String> nameList = new ArrayList<String>();
    List<Double> scoreList = new ArrayList<Double>();

    while (true) {
        System.out.printf("Enter first name of student or done to finish: ");
        String fname = keyboard.next();
        if (fname.equals("done")) {
            break;
        }
        System.out.printf("Enter last name of student: ");
        String lname = keyboard.next();
        nameList.add(fname + " " + lname);
        System.out.println("Enter score: ");
        scoreList.add(keyboard.nextDouble());
    }
    keyboard.close();
    System.out.println("Names: " + nameList);
    System.out.println("scores: " + scoreList);
}