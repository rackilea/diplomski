public int countOccurance(Comparable data2){
    int count = 0;
    for (int i =0; i < size; i++){
        if(data[i] != null && data[i].equals(data2)){
            count++;
        }
    }
    return count;
}