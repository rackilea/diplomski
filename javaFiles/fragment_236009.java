int[] colSum =new int[array[0].length];
for (int i = 0; i < array.length; i++){   
    for (int j = 0; j < array[i].length; j++){                
        sum += array[i][j];
        colSum[j] += array[i][j];
    }
    System.out.println("Print the sum of rows =" + sum);
}  
for(int k=0;k<colSum.length;k++){
    System.out.println("Print the sum of columns =" + colSum[k]);
}