private static void printArray(){
     if(unittest == null)
        System.out.println("its NULL");
     else{
        for (int i = 0; i < unittest.length; i++){ //**NULL POINTER EXCEPTION
           for (int j = 0; j < unittest[i].length; j++){
              System.out.print(unittest[i][j]); 
              if (j < unittest[i].length - 1){
                 System.out.print(" ");
              }
           }
           System.out.println();
        }
     }
}