int maxIndex = 0;
    for(int i = 0;i < values.length;i++){
        if(values[i] > values[maxIndex]){
            maxIndex = i;
        }
    }