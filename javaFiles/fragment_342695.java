public void zeroOut(int[][] myArray){
    ArrayList<Integer> rowsToZero = new....
    ArrayList<Integer> columnsToZero = new....

    for(int i=0; i<myArray.length; i++){ // record which rows and columns will be zeroed
        for(int j=0; j<myArray[i].length; i++){
            if(myArray[i][j] == 0){
                if(!rowsToZero.contains(i)) rowsToZero.add(i);
                if(!columnsToZero.contains(j)) columnsToZero.add(j);
            }
        }
    }
    for(int row : rows){ // now zero the rows
        myArray[row] = int[myArray.length];
    }

    for(int i=0; i<myArray.length; i++){
        for(int column: columns){ // now zero the columns
            myArray[i][column] = 0;
        }    
    }
}