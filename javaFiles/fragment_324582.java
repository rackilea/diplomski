static void staircase(int n) {

        //int n = scanner.nextInt();
    int size = n;

   for (int i = 0; i <= size-1; i++){
       for(int j = 5; j > i; j--){
            System.out.print(" ");
       }
        for(int j = 0; j <= i; j++){
            System.out.print("#");
        }
        System.out.println();
   }