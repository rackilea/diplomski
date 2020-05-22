for(int j = start; j <= end-1; j++){
        if(array[j] <= x){
            i++;
            temp = array[j];
            array[j] = array[i];
            array[i] = temp;
        }

    }