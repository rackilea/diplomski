Scanner keyboardScanner = new Scanner(System.in); 
    double[] array = new double[12]; 
    // creates for loop
    for (int i=0; i<12; i++)
    { 
    System.out.println("Enter Rental for month[" + i + "]"));
     array[i] = keyboardScanner.nextDouble();
    } 
    for (int i=0; i<array.length; i++) 
    { 
    System.out.println(array[i]);
    }