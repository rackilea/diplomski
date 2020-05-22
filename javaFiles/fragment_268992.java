public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String userInput = "";
    while (true) {
        System.out.println("Enter menu number: ");
        userInput = scanner.next();
        if (userInput.trim().toUpperCase().equals("EXIT")) {
            break;
        }
        int value = Integer.parseInt(userInput);

        if(value == 1){
            System.out.println("first");
        }
        else if(value==2){
            System.out.println("second");
        }
        else if(value==3){
             System.out.println("third");
        }

    }            
}