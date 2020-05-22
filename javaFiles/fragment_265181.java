static int bank = 0;

public static void main(String[] args) {
    boolean valid = true;
    Scanner scan = new Scanner(System.in);

    do {
        System.out.println("How much money do you want to convert to chips?");
        if(scan.hasNextInt()){
            bank = scan.nextInt();
            valid = true;
        }else{
            scan.nextLine();
            valid = false;
            System.out.println("Enter a valid integer value");
        }
    }while(!valid);
}