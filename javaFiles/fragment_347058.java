int total = 0;

for (int numValue =1; numValue <= addNumber; numValue++)
  {

    System.out.println("Please input your " + numValue + " value.");
    total += myInput.nextInt(); 
  }

System.out.println ("The total is " + total);