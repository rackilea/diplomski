for (int i = 0; i < length-1 ; i++) {
    for (int j = i+1; j < length; j++){
        if (vector.elements[i] > vector.elements[j]){
            long temp = vector.elements[i];
            vector.elements[i] = vector.elements[j];
            vector.elements[j] = temp;
            }
        }
    }