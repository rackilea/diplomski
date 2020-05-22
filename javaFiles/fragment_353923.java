public World(){        
    Scanner input = new Scanner(System.in);
    System.out.println("Enter number of rows: ");
    int crow = input.nextInt();
    System.out.println("Enter number of columns: ");
    int ccol = input.nextInt();
    array = new String[crow][ccol];
    //array[0][0]=P;
    //displayWorld();   
        for(int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[i].length; j++)
            {
                if(i == 0 && j == 0){
                 array[i][j] = P;
                }else{
                 array[i][j] = new String();
                }                    
            }
        }
    displayWorld();   
    }