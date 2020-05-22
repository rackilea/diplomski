Scanner reader = new Scanner(System.in);
int num = 0;
System.out.println("Type numbers: ");
while(true){
    //get user input
    num = Integer.parseInt(reader.nextLine());
    if(num == -1){
        System.out.println("Thank you and see you later!");
        break;
    }
}