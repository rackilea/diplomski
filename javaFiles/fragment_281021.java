// iterate over the old array.
for(int i=0; i < a.length; i++){

        // index into new array.
        int x = 2 * i;

        // copy old array ele at index i into new array at index x and x+1.
        j[x] = j[x+1] = a[i];        
}