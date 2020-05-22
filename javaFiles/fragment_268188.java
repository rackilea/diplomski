boolean result[] = new boolean[<num of columns>];
for (int i = 0; i < result.length; ++i)
    result[i] = true;

for (int row = 0; row < arrayA.length; ++row) {
   for (int col = 0; col < arrayA[row].length; ++col)
       result[col] &= arrayA[row][col] == 0; 
}

for (int row = 0; row < arrayB.length; ++row) {
       for (int col = 0; col < arrayB[row].length; ++col)
       result[col] &= arrayB[row][col] == 0; 
}

for (int i = 0; i < 6; ++i) 
    System.out.println(result[i]);