public static void main(String[] args)
{

    Scanner keyboard = new Scanner(System.in);

    System.out.println("[-------------------------]");
    System.out.println("[      Array Pattern      ]");
    System.out.println("[-------------------------]");

    System.out.println("How many rows/columns do you want your array to have? (Mist be at least 3):");


    int arraySize = keyboard.nextInt();

    while(arraySize < 3)
    {
        System.out.println("Lets try this again ....");
        System.out.println("How many rows/columns do you want your array to have? (Mist be at least 3):");
        arraySize = keyboard.nextInt();
    }


    int [][] pattern = new int[arraySize][arraySize];

    int number = 1;

    for(int i=0;i<arraySize;i++){
        if(i%2==0){
          for(int j=0;j<arraySize;j++){
               pattern[i][j]=number;
                number++;
             }
        }
        else{
            for(int j=arraySize-1;j>=0;j--){
                pattern[i][j]=number;
                number++;
            }
        }
        for(int j=0;j<arraySize;j++){
            System.out.printf("%3d", pattern[i][j]);
        }
        System.out.println();
    }
}