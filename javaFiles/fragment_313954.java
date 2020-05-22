public static int[] mergeSort(int[] in) {
    return mergeSort(in, 0);
}

public static int[] mergeSort(int[] in, int number_of_times_called) {

    int[] temp;
    if (number_of_times_called == 0)
        temp = in.clone();
    else
        temp = in

    if (temp.length <= 1){
        return temp;
    }


    else{
        int [] first = new int[temp.length/2];
        int [] second = new int [temp.length - first.length];

        for (int i=0; i<first.length; i++){
            first[i] = temp[i];
        }

        for (int i = 0; i < second.length; i++){
            second[i] = temp[first.length+i];
        }

        mergeSort(first);
        mergeSort(second);
        merg(first,second,temp);

    }

    return temp;
}

public static void merg(int [] first, int[] second, int []newTemp){


    int i =0;
    int j = 0;
    int k = 0;
    while(i <first.length && j < second.length ){

        if(first[i] <=second[j]){

            newTemp[k] = first[i];
            i++;
        }
        else{
            newTemp[k] = second[j];
            j++;

        }
        k++;

    }
    while (i < first.length){
        newTemp[k] = first[i];
        i++;
        k++;
    }
    while(j < second.length){
        newTemp[k]= second[j];
        j++;
        k++;
    }

}