public static void main(String[] args)
{

    Scanner scan = new Scanner(System.in);

    System.out.println("Input Land 1");
    int land1_A_Input = scan.nextInt();
    int land1_B_Input = scan.nextInt();

    System.out.println("Input Land 1");
    int land2_A_Input = scan.nextInt();
    int land2_B_Input = scan.nextInt();

     // Create two MitchellLandTract objects with the same values
     MitchellLandTract land1 = new MitchellLandTract(land1_A_Input, land1_B_Input);
     MitchellLandTract land2 = new MitchellLandTract(land2_A_Input, land2_B_Input);

     // Use the equals method to compare the objects
     if (land1.equals(land2))
         System.out.println("Both objects are the same.");
     else
         System.out.println("The objects are different.");

     // Display the objects' values
     System.out.println("For the first tract of land: " + land1);
     System.out.println("For the second tract of land: " + land2);
}