public static void main(final String args[])
{
    int maxRowsNumber = 10;
    int maxColsNumber = 10;
    Scanner scanner = new Scanner (System.in);
    int coordinates[] = new int[2];
    coordinates[0]=-1;  
    coordinates[1]=-1;
    boolean check = true;
    while (((coordinates[0]<0)||(coordinates[0]>maxRowsNumber))  && check) {
        System.out.print("Please enter a valid row number:\t");
        try { 
            coordinates[0]=scanner.nextInt(); 
        }
        catch (InputMismatchException e) {
            System.out.println("That's not a valid number.");
            scanner.nextLine();
        }
    }
    while (((coordinates[1]<0)||(coordinates[1]>maxColsNumber)) && check) {
        System.out.print("Please enter a valid col number:\t");
        try { 
            coordinates[1]=scanner.nextInt(); 
        }
        catch (InputMismatchException e) {
            System.out.println("That's not a valid number.");
            scanner.nextLine();
        }       
    }
    System.out.println("Inserted RowsNumber: " + coordinates[0]);
    System.out.println("Inserted RowsNumber: " + coordinates[1]);
}