Scanner keyboard  = new Scanner(System.in);
System.out.print("Enter Telephone letters : ");
while (keyboard.hasNextLine()) {
        String telephone_letter = keyboard.nextLine();
        ...
        System.out.println("");
        System.out.print("Enter Telephone letters : ");
}