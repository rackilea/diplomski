}   =======>EXTRA 
    // getNotGreen module
    static void getNotGreen(){
    Scanner in = new Scanner(System.in);
    for(int ctr=0;ctr<6;ctr++){
          System.out.println("Enter NOT GREEN energy costs for: "+months[ctr]);
          notGreenCost[ctr]=in.nextInt();
        }
    }