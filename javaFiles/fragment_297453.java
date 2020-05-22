public static void main(String[] args) {
    System.out.println("What is kek? (Top, bottom, etc.)");

    Scanner input = new Scanner(System.in);
    String string = input.nextLine();

    if(string.equals("kek")){
        System.out.println("No.");
        System.exit(0);
    }else{
        System.out.println(string + "kek");
        input.close();        
    }    
}