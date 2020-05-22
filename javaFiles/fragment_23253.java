private static void myfunction() {
    //put your code here
}

public static void main(String[] args) {

    String exit;
    Scanner scan = new Scanner(System.in);
    do {
        //call your function or you can put all your code here
        myfunction();
        System.out.println("You want to continue? y : n :");
        exit = scan.next();
    } while (exit.equals("y"));
}