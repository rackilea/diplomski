double[][] sum = new double[3][]; //Make sure this is unique within the scope
for(int i = 0; i < 3; i++) { //if you want dynamic scaling you'll need to replace 3 in the array as well.
    int size = n[i].length; //size of the new row
    sum[i] = new double[size]; // Inserting a new array of the wanted size
    for(int j = 0; j< sum[i].length; j++) 
    {
        sum[i][j]= n[i][j] + m[i][j]; 
    }
}
return sum;