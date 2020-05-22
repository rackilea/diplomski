public static int[] methodname3(int d[]) {
    int largest = d[0] - 1; // this makes sure that negative values are checked
    int instances = 0;
    int[] indices = null;

    for (int i = 0; i < d.length; i++){
        if (d[i] > largest){
            largest = d[i];
            instances = 1;
        }
        else if(d[i] == largest){
            instances++;
        }
    }

    indices = new int[instances];

    for(int i = 0, j = 0; i < d.length; i++){
        if(d[i] == largest){
            indices[j] = i;
            j++;
        }
    }

    return indices;
}