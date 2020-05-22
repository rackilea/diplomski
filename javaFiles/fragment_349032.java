public static void main(String[] args) {
    boolean wenttocatch = false;
    Scanner scan = new Scanner(System.in);
    int number_of_rigons = 0;
    do{
        System.out.print("Enter a number : ");
        if(scan.hasNextInt()){
            number_of_rigons = scan.nextInt();
            wenttocatch = true;
        }else{
            scan.nextLine();
            System.out.println("Enter a valid Integer value");
        }
    }while(!wenttocatch);
}