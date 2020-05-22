public Sudoku(String sud){
     int pos = 0;
     String character="";
     sudoku = new int[sud.length()/9][sud.length()/9];
     for(int i=0; i<sudoku.length; i++){
        for(int j=0; j<sudoku.length; j++){
            pos = i*sud.length()/9 + j;
            character = sud.charAt(pos)+"";
            sudoku[i][j] = Integer.parseInt(character); // you forgot this
        }
     }
   }