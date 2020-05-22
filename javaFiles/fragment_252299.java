public static void main( String[] args )
{
    Scanner           scan        = new Scanner(System.in);
    ArrayList<Double> myArr       = new ArrayList<Double>();
    int               entriesLeft = 20; // changed counter that counts upwards to one counting down.

    System.out.println("Enter one number at a time be averaged, you have 20 entries remaining:");

    // added additional condition to be checked: we now also stop if maximum number of entries ie reached.
    for (String inputs = scan.nextLine() ; entriesLeft > 0 && !inputs.matches("[qQ]")  ; inputs = scan.nextLine())
    {
        try{
            myArr.add(Double.valueOf(inputs));
            entriesLeft--; //counting one down
            System.out.println("Please enter another number or press Q for your average");
            // telling user how much numbers are left
            System.out.println("You have " + entriesLeft + "numbers left.");
        }
        catch (NumberFormatException e) {
            System.out.println("Try again you tard! You entered more than one number, or not a valid number at all.");
            continue;                   
        }      

    }
    Double average = calculate_average(myArr);
    System.out.println("Your average is: " + average);
}