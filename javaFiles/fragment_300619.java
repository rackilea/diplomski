public static String methodname3(int d[]){
    int largest = d[0] - 1;
    String indices = "";

    for (int i = 0; i < d.length; i++){
        if (d[i] > largest){
            largest = d[i];
            indices = i; // This resets the String each time a larger value is found
        }
        else if(d[i] == largest){
            indices = indices + " " + i; 
            // This results in a space delimited String of indices
        }
    }

    return indices;
}