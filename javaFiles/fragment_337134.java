Scanner scan = new Scanner(System.in);

String response;

do{    
    System.out.print("Do you have a pet ? (Y/N): ");
    response = scan.nextLine();    
} while(!response.equalsIgnoreCase("Y") && !response.equalsIgnoreCase("N"));

if(response.equalsIgnoreCase("N")){
    System.exit(0);
}

do{    
    System.out.print("Cat or a dog ? (C/D): ");
    response = scan.nextLine();    
} while(!response.equalsIgnoreCase("C") && !response.equalsIgnoreCase("D"));