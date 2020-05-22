public static void main(String[] args) {
        int max = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Number of matrix?");
        max = scan.nextInt();

        List<int[][]> allMatrices = new ArrayList<int[][]>(max);

        for(int i = 0; i < max; i++){
            int x[][]=new int [2][2];
            allMatrices.add(x);
        }


  // To acces the 2 D arrays 

    foreach(int [][] x : allMatrices){


    for(int i=0;i<x.length;i++)
     {
       for(int j=0;j<x[i].length ;j++)
         {
       // do some operation on    x[i][j]
          }
     }

          }