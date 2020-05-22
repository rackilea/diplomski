Scanner scan = new Scanner(System.in); 
  double[] rainfall; 
  double totalRainfall = 0.0; 
  double max = 0, min  = 0;
  int year = 0;
  int maxQuarter = 1;
  int minQuarter = 1;

  System.out.println("Enter the number of years: ");
  year = scan.nextInt();
  rainfall = new double[year*4]